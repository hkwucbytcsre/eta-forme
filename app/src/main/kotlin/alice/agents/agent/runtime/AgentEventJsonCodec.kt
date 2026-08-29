<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/runtime/AgentEventJsonCodec.kt
package alice.agents.agent.runtime
========
package io.github.mangi.eta.agent.runtime
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/runtime/AgentEventJsonCodec.kt

import android.os.Bundle
import org.json.JSONArray
import org.json.JSONObject

/** Runtime 事件的稳定 JSON 投影；只编码 IPC 已公开的安全字段。 */
internal object AgentEventJsonCodec {
    fun encode(event: AgentEvent): String = bundleToJson(
        AgentRuntimeWire.eventToBundle(event)
    ).toString()

    fun decode(raw: String): AgentEvent? = runCatching {
        AgentRuntimeWire.eventFromBundle(jsonToBundle(JSONObject(raw)))
    }.getOrNull()

    @Suppress("DEPRECATION")
    private fun bundleToJson(bundle: Bundle): JSONObject =
        JSONObject().also { json ->
            bundle.keySet().forEach { key ->
                when (val value = bundle.get(key)) {
                    is String -> json.put(key, value)
                    is Boolean -> json.put(key, value)
                    is Int -> json.put(key, value)
                    is Long -> json.put(key, value)
                    is ArrayList<*> -> json.put(key, JSONArray(value))
                    null -> json.put(key, JSONObject.NULL)
                }
            }
        }

    private fun jsonToBundle(json: JSONObject): Bundle =
        Bundle().also { bundle ->
            json.keys().forEach { key ->
                when (val value = json.opt(key)) {
                    is String -> bundle.putString(key, value)
                    is Boolean -> bundle.putBoolean(key, value)
                    is Int -> bundle.putInt(key, value)
                    is Long -> bundle.putLong(key, value)
                    is JSONArray -> bundle.putStringArrayList(
                        key,
                        ArrayList((0 until value.length()).map { index -> value.optString(index) }),
                    )
                }
            }
        }
}
