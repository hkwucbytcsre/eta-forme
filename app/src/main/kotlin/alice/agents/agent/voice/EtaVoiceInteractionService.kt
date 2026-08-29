<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/voice/EtaVoiceInteractionService.kt
package alice.agents.agent.voice
========
package io.github.mangi.eta.agent.voice
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/voice/EtaVoiceInteractionService.kt

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.service.voice.VoiceInteractionService
import android.service.voice.VoiceInteractionSession

class EtaVoiceInteractionService : VoiceInteractionService() {
    override fun onReady() {
        super.onReady()
        activeService = this
        if (Build.VERSION.SDK_INT >= 37) {
            setInvocationEffectEnabled(true)
        }
    }

    override fun onShutdown() {
        if (activeService === this) activeService = null
        super.onShutdown()
    }

    override fun onLaunchVoiceAssistFromKeyguard() {
        startActivity(
            Intent(this, EtaVoiceAssistActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK),
        )
    }

    private fun showEtaSession() {
        showSession(Bundle(), VoiceInteractionSession.SHOW_WITH_ASSIST)
    }

    companion object {
        @Volatile
        private var activeService: EtaVoiceInteractionService? = null

        internal fun requestSession(): Boolean {
            val service = activeService ?: return false
            service.showEtaSession()
            return true
        }
    }
}

class EtaVoiceAssistActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EtaVoiceInteractionService.requestSession()
        finish()
    }
}
