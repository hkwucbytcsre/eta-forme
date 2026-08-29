<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/model/AgentToolSchema.kt
package alice.agents.agent.model
========
package io.github.mangi.eta.agent.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/model/AgentToolSchema.kt

import org.json.JSONArray
import org.json.JSONObject

internal object AgentToolSchema {
    fun coordinateSpace(): JSONObject =
        JSONObject()
            .put("type", "string")
            .put("enum", JSONArray().put("screenshot").put("screen"))
            .put(
                "description",
                "screenshot 表示最近一次 observe_screen 附图的像素坐标；screen 表示真实设备屏幕坐标。默认 screenshot。",
            )

    fun function(
        name: String,
        description: String,
        parameters: JSONObject,
    ): JSONObject =
        JSONObject()
            .put("type", "function")
            .put(
                "function",
                JSONObject()
                    .put("name", name)
                    .put("description", description)
                    .put("parameters", parameters),
            )
}
