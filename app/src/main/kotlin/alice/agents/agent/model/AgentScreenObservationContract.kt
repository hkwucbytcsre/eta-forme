<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/model/AgentScreenObservationContract.kt
package alice.agents.agent.model
========
package io.github.mangi.eta.agent.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/model/AgentScreenObservationContract.kt

import org.json.JSONObject

/** 屏幕观察工具在模型 schema、执行器与运行轨迹之间共享的默认合同。 */
internal object AgentScreenObservationContract {
    const val DEFAULT_INCLUDE_SCREENSHOT = false
    const val DEFAULT_INCLUDE_UI_TREE = true
    const val DEFAULT_MAX_NODES = 60
    const val MIN_MAX_NODES = 1
    const val MAX_MAX_NODES = 120

    data class Options(
        val includeScreenshot: Boolean,
        val includeUiTree: Boolean,
        val maxNodes: Int,
    )

    fun resolve(arguments: JSONObject): Options = Options(
        includeScreenshot = arguments.optBoolean(
            "include_screenshot",
            DEFAULT_INCLUDE_SCREENSHOT,
        ),
        includeUiTree = arguments.optBoolean(
            "include_ui_tree",
            DEFAULT_INCLUDE_UI_TREE,
        ),
        maxNodes = arguments.optInt("max_nodes", DEFAULT_MAX_NODES),
    )
}
