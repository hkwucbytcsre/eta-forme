<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/device/ScreenshotOutcomePolicy.kt
package alice.agents.agent.device
========
package io.github.mangi.eta.agent.device
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/device/ScreenshotOutcomePolicy.kt

internal enum class ScreenshotQuality(val wireName: String) {
    NOT_REQUESTED("not_requested"),
    COMPLETE("complete"),
    PARTIAL("partial"),
    FAILED("failed"),
}

internal object ScreenshotOutcomePolicy {
    fun classify(
        requested: Boolean,
        hasImage: Boolean,
        complete: Boolean,
    ): ScreenshotQuality = when {
        !requested -> ScreenshotQuality.NOT_REQUESTED
        hasImage && complete -> ScreenshotQuality.COMPLETE
        hasImage -> ScreenshotQuality.PARTIAL
        else -> ScreenshotQuality.FAILED
    }

    fun mayFallbackToRoot(
        excludedPackagesPresent: Boolean,
        criticalWindowMissing: Boolean,
    ): Boolean = !excludedPackagesPresent && !criticalWindowMissing
}
