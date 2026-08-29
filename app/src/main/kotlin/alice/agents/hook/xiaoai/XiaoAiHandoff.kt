<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/hook/xiaoai/XiaoAiHandoff.kt
package alice.agents.hook.xiaoai

import alice.agents.agent.runtime.AgentExternalArchivePayload
import alice.agents.agent.runtime.AgentRuntimeWire
========
package io.github.mangi.eta.hook.xiaoai

import io.github.mangi.eta.agent.runtime.AgentExternalArchivePayload
import io.github.mangi.eta.agent.runtime.AgentRuntimeWire
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/hook/xiaoai/XiaoAiHandoff.kt
import org.json.JSONObject

internal object XiaoAiHandoff {
    const val SOURCE = "xiaoai"
    private const val ARCHIVE_TITLE_CHARS = 20

    fun create(
        runId: String,
        dialogId: String,
        prompt: String,
    ): AgentRuntimeWire.EntryHandoff =
        AgentRuntimeWire.EntryHandoff(
            id = runId,
            source = SOURCE,
            dismissEntrySurfaceOnForegroundOperation = true,
            payload = AgentExternalArchivePayload(
                userText = prompt,
                conversationKey = dialogId,
                title = archiveTitle(prompt),
                adapterPayload = JSONObject().put("dialogId", dialogId),
            ).toJson(),
        )

    fun dialogIdFrom(handoff: AgentRuntimeWire.EntryHandoff): String {
        if (handoff.source != SOURCE) return ""
        val payload = AgentExternalArchivePayload.from(handoff.payload) ?: return ""
        return payload.adapterPayload.optString("dialogId")
    }

    private fun archiveTitle(prompt: String): String {
        val firstLine = prompt.lineSequence().firstOrNull().orEmpty().trim()
        return if (firstLine.isBlank()) {
            "超级小爱对话"
        } else {
            "超级小爱：${firstLine.take(ARCHIVE_TITLE_CHARS)}"
        }
    }
}
