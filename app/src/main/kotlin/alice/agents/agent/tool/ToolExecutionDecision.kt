<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/tool/ToolExecutionDecision.kt
package alice.agents.agent.tool
========
package io.github.mangi.eta.agent.tool
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/tool/ToolExecutionDecision.kt

internal sealed interface ToolExecutionDecision {
    data object Allow : ToolExecutionDecision

    data class Reject(
        val code: String,
        val message: String,
    ) : ToolExecutionDecision
}
