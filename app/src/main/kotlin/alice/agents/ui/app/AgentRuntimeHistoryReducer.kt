<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/app/AgentRuntimeHistoryReducer.kt
package alice.agents.ui.app

import alice.agents.agent.model.AgentModelClient
import alice.agents.ui.model.AgentChatHomeUiState
========
package io.github.mangi.eta.ui.app

import io.github.mangi.eta.agent.model.AgentModelClient
import io.github.mangi.eta.ui.model.AgentChatHomeUiState
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/app/AgentRuntimeHistoryReducer.kt

/** live result 与 outbox recovery 共用的 history 幂等提交点。 */
internal object AgentRuntimeHistoryReducer {
    data class Outcome(
        val state: AgentChatHomeUiState,
        val alreadyApplied: Boolean,
    )

    fun apply(
        state: AgentChatHomeUiState,
        runId: String,
        additions: List<AgentModelClient.ConversationMessage>,
    ): Outcome {
        if (runId in state.appliedRuntimeRunIds) {
            return Outcome(state, alreadyApplied = true)
        }
        return Outcome(
            state = state.copy(
                history = state.history + additions,
                appliedRuntimeRunIds = (state.appliedRuntimeRunIds + runId)
                    .takeLast(MAX_APPLIED_RUN_IDS),
            ),
            alreadyApplied = false,
        )
    }

    fun wasApplied(state: AgentChatHomeUiState, runId: String): Boolean =
        runId in state.appliedRuntimeRunIds

    private const val MAX_APPLIED_RUN_IDS = 128
}
