<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/config/PowerAssistantTarget.kt
package alice.agents.config
========
package io.github.mangi.eta.config
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/config/PowerAssistantTarget.kt

internal enum class PowerAssistantTarget(
    val persistedValue: String,
) {
    ETA("eta"),
    GEMINI("gemini"),
    OEM("oem"),
    ;

    companion object {
        fun resolve(
            persistedValue: String?,
            legacyPowerKeyTakeover: Boolean,
        ): PowerAssistantTarget = entries.firstOrNull {
            it.persistedValue == persistedValue
        } ?: if (legacyPowerKeyTakeover) {
            GEMINI
        } else {
            OEM
        }
    }
}
