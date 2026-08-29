<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/runtime/AgentRuntimeRequestConfigResolver.kt
package alice.agents.agent.runtime

import alice.agents.agent.model.AgentModelClient
========
package io.github.mangi.eta.agent.runtime

import io.github.mangi.eta.agent.model.AgentModelClient
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/runtime/AgentRuntimeRequestConfigResolver.kt

internal object AgentRuntimeRequestConfigResolver {
    fun requiresRuntimeConfig(request: AgentRuntimeWire.RunRequest): Boolean =
        request.handoff?.source == AgentRuntimeWire.ETA_VOICE_HANDOFF_SOURCE

    fun applyRuntimeConfig(
        request: AgentRuntimeWire.RunRequest,
        config: AgentModelClient.ModelConfig,
    ): AgentRuntimeWire.RunRequest {
        if (!requiresRuntimeConfig(request)) return request
        val handoff = request.handoff ?: return request.copy(config = config)
        val archivePayload = AgentExternalArchivePayload.from(handoff.payload)
        return request.copy(
            config = config,
            handoff = archivePayload?.let { payload ->
                handoff.copy(
                    payload = payload.copy(
                        thinkingEnabled = config.effectiveReasoningEffort.enablesReasoning,
                        reasoningEffort = config.effectiveReasoningEffort,
                    ).toJson(),
                )
            } ?: handoff,
        )
    }
}
