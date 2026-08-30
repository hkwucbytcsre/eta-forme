package alice.agents.ui.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import alice.agents.agent.terminal.DetachedTaskSupervisor
import alice.agents.agent.terminal.LinuxEnvironmentPaths
import alice.agents.agent.terminal.LinuxPackageProfiles
import alice.agents.agent.terminal.SharedFolderMounts
import alice.agents.agent.terminal.linuxPackageProfileReady
import alice.agents.agent.terminal.terminalEnvironment
import alice.agents.core.AndroidAgentLogger
import alice.agents.data.repository.LinuxEnvironmentSettingsRepository
import kotlinx.coroutines.launch

/** Activity 级状态所有者；配置变更只重建 UI，不替换正在运行的 Agent 会话。 */
internal class AgentAppViewModel(application: Application) : AndroidViewModel(application) {
    val state = AgentAppState(
        context = application,
        scope = viewModelScope,
    )
    val terminalStore = UserTerminalStore(
        context = application,
        scope = viewModelScope,
    )
    val consoleStore = ConsoleStore(
        context = application,
        scope = viewModelScope,
    )
    val kimiWebLauncher = KimiWebLauncher(
        context = application,
        daemonSupervisor = DetachedTaskSupervisor(
            logger = AndroidAgentLogger,
            recordsFile = DetachedTaskSupervisor.defaultRecordsFile(application),
            linuxRootfsPathProvider = { environment ->
                environment.linuxDistribution?.let { distribution ->
                    LinuxEnvironmentPaths.rootfsDir(application, distribution).absolutePath
                }
            },
            linuxSharedMountsProvider = { SharedFolderMounts.current() },
        ),
    )

    /** Kimi Code profile 是否已就绪；未就绪时入口应引导到安装页。 */
    fun kimiWebReady(): Boolean {
        val distribution = LinuxEnvironmentSettingsRepository.current(getApplication())
        val rootfs = LinuxEnvironmentPaths.rootfsDir(getApplication(), distribution)
        return linuxPackageProfileReady(rootfs, LinuxPackageProfiles.KIMI)
    }

    fun launchKimiWeb(onFinished: (KimiWebLaunchResult) -> Unit) {
        viewModelScope.launch {
            val distribution = LinuxEnvironmentSettingsRepository.current(getApplication())
            onFinished(kimiWebLauncher.launch(distribution.terminalEnvironment))
        }
    }

    override fun onCleared() {
        terminalStore.close()
        consoleStore.close()
        super.onCleared()
    }
}
