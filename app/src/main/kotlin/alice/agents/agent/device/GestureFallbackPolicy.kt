<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/device/GestureFallbackPolicy.kt
package alice.agents.agent.device
========
package io.github.mangi.eta.agent.device
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/device/GestureFallbackPolicy.kt

/** 只有确认手势从未提交给系统时，才允许改用 Root 重放。 */
internal object GestureFallbackPolicy {
    fun mayFallbackToRoot(errorCode: String): Boolean =
        errorCode == "GESTURE_NOT_DISPATCHED"
}
