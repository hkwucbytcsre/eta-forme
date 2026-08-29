<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/voice/EtaVoiceInteractionSessionService.kt
package alice.agents.agent.voice
========
package io.github.mangi.eta.agent.voice
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/voice/EtaVoiceInteractionSessionService.kt

import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.service.voice.VoiceInteractionSessionService

class EtaVoiceInteractionSessionService : VoiceInteractionSessionService() {
    override fun onNewSession(args: Bundle): VoiceInteractionSession =
        EtaVoiceInteractionSession(this)
}
