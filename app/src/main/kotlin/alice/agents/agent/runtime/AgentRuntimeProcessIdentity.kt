<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/runtime/AgentRuntimeProcessIdentity.kt
package alice.agents.agent.runtime
========
package io.github.mangi.eta.agent.runtime
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/runtime/AgentRuntimeProcessIdentity.kt

import java.util.UUID

/** 记录 checkpoint 的创建进程，仅供诊断；恢复状态由 Runtime 对账决定。 */
internal object AgentRuntimeProcessIdentity {
    val id: String = UUID.randomUUID().toString()
}
