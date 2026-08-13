package alice.agents.agent.voice

import android.content.Context
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.view.View
<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/voice/EtaVoiceInteractionSession.kt
import android.view.WindowManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.setViewTreeLifecycleOwner
import androidx.savedstate.SavedStateRegistry
import androidx.savedstate.SavedStateRegistryController
import androidx.savedstate.SavedStateRegistryOwner
import androidx.savedstate.setViewTreeSavedStateRegistryOwner
import alice.agents.R
import alice.agents.agent.model.AgentModelClient
import alice.agents.agent.overlay.AgentOverlayVisibilityPolicy
import alice.agents.agent.runtime.AgentEvent
import alice.agents.agent.runtime.AgentExternalArchivePayload
import alice.agents.agent.runtime.AgentRuntimeClient
import alice.agents.agent.runtime.AgentRuntimeWire
import alice.agents.core.AndroidAgentLogger
import alice.agents.ui.app.AgentAppTheme
import java.util.UUID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class EtaVoiceInteractionSession(context: Context) :
    VoiceInteractionSession(context),
    LifecycleOwner,
    SavedStateRegistryOwner {
    init {
        setTheme(R.style.Theme_EtaVoiceInteractionSession)
    }

    private val lifecycleRegistry = LifecycleRegistry(this)
    private val savedStateRegistryController = SavedStateRegistryController.create(this)

    override val lifecycle: Lifecycle get() = lifecycleRegistry
    override val savedStateRegistry: SavedStateRegistry
        get() = savedStateRegistryController.savedStateRegistry

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val runtimeClient = AgentRuntimeClient(context, AndroidAgentLogger)
    private val conversationKey = "eta_voice_${UUID.randomUUID()}"
    private var conversationHistory = emptyList<AgentModelClient.ConversationMessage>()
    private var runJob: Job? = null
    private var activeRunId: String? = null
    private var hiddenForForegroundOperation = false
    private var inputText by mutableStateOf("")
    private var inputFocusRequestKey by mutableStateOf(-1)
    private var uiState by mutableStateOf(
        EtaVoiceUiState(
            phase = EtaVoicePhase.READY,
            status = "输入请求",
        ),
    )
=======
>>>>>>> 6dd5715 (feat(assistant): 重构系统助理浮窗交互):app/src/main/kotlin/fuck/andes/agent/voice/EtaVoiceInteractionSession.kt

/**
 * 系统数字助理的入口桥接。
 *
 * 系统会为本类创建 TYPE_VOICE_INTERACTION 窗口，但 Eta 的实际界面由自己的
 * TYPE_APPLICATION_OVERLAY 窗口承载，避免把厂商助手动画和输入层级绑定到系统会话窗口。
 */
internal class EtaVoiceInteractionSession(context: Context) : VoiceInteractionSession(context) {
    override fun onCreate() {
        super.onCreate()
        setUiEnabled(false)
    }

    override fun onCreateContentView(): View = View(context)

    override fun onShow(args: Bundle?, showFlags: Int) {
        super.onShow(args, showFlags)
        EtaAssistantOverlayService.show(context)
    }

    override fun onBackPressed() {
        EtaAssistantOverlayService.dismiss(context)
        hide()
    }

    override fun onCloseSystemDialogs() {
        EtaAssistantOverlayService.dismiss(context)
        hide()
    }

    override fun onDestroy() {
        // 浮窗拥有独立生命周期；系统会话重建不代表用户关闭了助理。
        super.onDestroy()
    }
}
