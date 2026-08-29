<<<<<<<< HEAD:app/src/test/java/alice/agents/ui/app/AgentRuntimeHistoryReducerTest.kt
package alice.agents.ui.app

import alice.agents.agent.model.AgentModelClient
import alice.agents.ui.model.AgentChatUiState
========
package io.github.mangi.eta.ui.app

import io.github.mangi.eta.agent.model.AgentModelClient
import io.github.mangi.eta.ui.model.AgentChatUiState
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/ui/app/AgentRuntimeHistoryReducerTest.kt
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AgentRuntimeHistoryReducerTest {
    @Test
    fun recoveryThenLiveDeliveryCommitsTranscriptOnlyOnce() {
        val initial = AgentChatUiState(
            messages = emptyList(),
            input = "",
            isStreaming = true,
            thinkingEnabled = false,
        )
        val transcript = listOf(
            AgentModelClient.ConversationMessage(role = "assistant", content = "完成")
        )

        val recovered = AgentRuntimeHistoryReducer.apply(initial, "run-1", transcript)
        val live = AgentRuntimeHistoryReducer.apply(recovered.state, "run-1", transcript)

        assertTrue(live.alreadyApplied)
        assertEquals(transcript, live.state.history)
        assertEquals(listOf("run-1"), live.state.appliedRuntimeRunIds)
    }
}
