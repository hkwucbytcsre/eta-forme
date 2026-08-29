<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/runtime/AgentEventRecoveryProjection.kt
package alice.agents.agent.runtime
========
package io.github.mangi.eta.agent.runtime
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/runtime/AgentEventRecoveryProjection.kt

/** 恢复日志只保留 UI 可见事件；工具参数增量仍只存在于当前模型回合。 */
internal fun AgentEvent.recoveryProjection(): AgentEvent? = when (this) {
    is AgentEvent.AssistantBlockDelta ->
        takeUnless { kind == AgentEvent.AssistantBlockKind.TOOL_CALL }
    else -> this
}
