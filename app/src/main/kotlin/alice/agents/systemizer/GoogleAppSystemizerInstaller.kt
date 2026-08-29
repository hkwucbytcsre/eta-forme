<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/systemizer/GoogleAppSystemizerInstaller.kt
package alice.agents.systemizer
========
package io.github.mangi.eta.systemizer
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/systemizer/GoogleAppSystemizerInstaller.kt

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/systemizer/GoogleAppSystemizerInstaller.kt
import alice.agents.core.AndroidAgentLogger
import alice.agents.core.safeLogType
========
import io.github.mangi.eta.core.AndroidAgentLogger
import io.github.mangi.eta.core.safeLogType
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/systemizer/GoogleAppSystemizerInstaller.kt
import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

internal data class RootProbeResult(
    val exitCode: Int,
    val output: String,
) {
    val isKernelSu: Boolean
        get() = exitCode == 0 && output.contains("KernelSU", ignoreCase = true)

    val isMagisk: Boolean
        get() = exitCode == 0 && output.contains("Magisk", ignoreCase = true)
}

internal enum class RootManager {
    MAGISK,
    KERNEL_SU,
    UNSUPPORTED,
}

internal sealed interface SystemizerInstallResult {
    data object AlreadySystemized : SystemizerInstallResult
    data object GoogleAppMissing : SystemizerInstallResult
    data object UnsupportedRootManager : SystemizerInstallResult
    data object KernelSuMetamoduleMissing : SystemizerInstallResult
    data class RootPermissionUnavailable(val rootManager: RootManager) : SystemizerInstallResult
    data class InstalledRebootRequired(val rootManager: RootManager) : SystemizerInstallResult
    data class Failed(val message: String, val commandOutput: String = "") : SystemizerInstallResult
}

internal class GoogleAppSystemizerInstaller(
    private val context: Context,
) {

    fun install(): SystemizerInstallResult {
        // 安装功能已移除，直接返回失败
        return SystemizerInstallResult.Failed("安装功能已移除，不再支持")
    }

    fun isGoogleAppSystemPrivApp(): Boolean {
        val appInfo = findGoogleAppInfo() ?: return false
        val systemApp = appInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0 ||
            appInfo.flags and ApplicationInfo.FLAG_UPDATED_SYSTEM_APP != 0
        return systemApp && appInfo.hasPrivilegedPrivateFlag()
    }

    private fun detectRootManager(): RootManager =
        detectRootManager(
            suVersionProbe = runProcess(timeoutSeconds = 8, "su", "-v").toRootProbeResult(),
        )

    private fun canRunRootCommands(): Boolean {
        val result = runSu("id -u", timeoutSeconds = 8)
        return result.exitCode == 0 && result.output.lineSequence().any { it.trim() == "0" }
    }

    private fun findGoogleAppInfo(): ApplicationInfo? =
        runCatching {
            context.packageManager.getApplicationInfo(
                GOOGLE_PACKAGE,
                PackageManager.ApplicationInfoFlags.of(0),
            )
        }.getOrNull()

    private fun runSu(command: String, timeoutSeconds: Long): RootCommandResult {
        return runProcess(timeoutSeconds, "su", "-c", command)
    }

    private fun runProcess(timeoutSeconds: Long, vararg command: String): RootCommandResult {
        val process = runCatching {
            ProcessBuilder(*command)
                .redirectErrorStream(true)
                .start()
        }.getOrElse {
            return RootCommandResult(exitCode = -1, output = it.message.orEmpty())
        }

        val output = StringBuilder()
        val reader = thread(name = "google-systemizer-shell-reader") {
            runCatching {
                process.inputStream.bufferedReader().useLines { lines ->
                    lines.forEach { output.appendLine(it) }
                }
            }
        }

        val finished = process.waitFor(timeoutSeconds, TimeUnit.SECONDS)
        if (!finished) {
            process.destroyForcibly()
            reader.join(1000)
            return RootCommandResult(exitCode = -2, output = "命令执行超时")
        }

        reader.join(1000)
        return RootCommandResult(exitCode = process.exitValue(), output = output.toString().trim())
    }

    companion object {
        private const val GOOGLE_PACKAGE = "com.google.android.googlequicksearchbox"

        fun detectRootManager(
            suVersionProbe: RootProbeResult = RootProbeResult(exitCode = -1, output = ""),
        ): RootManager = when {
            suVersionProbe.isKernelSu -> RootManager.KERNEL_SU
            suVersionProbe.isMagisk -> RootManager.MAGISK
            else -> RootManager.UNSUPPORTED
        }
    }
}

private data class RootCommandResult(
    val exitCode: Int,
    val output: String,
) {
    fun toRootProbeResult(): RootProbeResult =
        RootProbeResult(exitCode = exitCode, output = output)
}

private fun ApplicationInfo.hasPrivilegedPrivateFlag(): Boolean {
    val privateFlags = runCatching {
        ApplicationInfo::class.java
            .getDeclaredField("privateFlags")
            .also { it.isAccessible = true }
            .getInt(this)
    }.getOrNull()

    val privilegedFlag = runCatching {
        ApplicationInfo::class.java
            .getDeclaredField("PRIVATE_FLAG_PRIVILEGED")
            .getInt(null)
    }.getOrDefault(1 shl 3)

    if (privateFlags != null) {
        return privateFlags and privilegedFlag != 0
    }

    return sourceDir?.contains("/priv-app/") == true ||
        publicSourceDir?.contains("/priv-app/") == true
}