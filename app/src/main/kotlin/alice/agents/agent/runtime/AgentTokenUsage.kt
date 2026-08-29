<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/runtime/AgentTokenUsage.kt
package alice.agents.agent.runtime
========
package io.github.mangi.eta.agent.runtime
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/runtime/AgentTokenUsage.kt

internal data class AgentTokenUsage(
    val contextTokens: Int? = null,
    val inputTokens: Int? = null,
    val outputTokens: Int? = null,
    val reasoningTokens: Int? = null,
    val cachedTokens: Int? = null,
) {
    val isEmpty: Boolean
        get() = contextTokens == null &&
            inputTokens == null &&
            outputTokens == null &&
            reasoningTokens == null &&
            cachedTokens == null
}
