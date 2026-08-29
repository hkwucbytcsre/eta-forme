<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/data/model/Settings.kt
package alice.agents.data.model
========
package io.github.mangi.eta.data.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/data/model/Settings.kt

import kotlinx.serialization.Serializable

@Serializable
data class Settings(
    val selectedProviderId: String? = null,
    val selectedModelId: String? = null,
    val memoryEnabled: Boolean = true,
    val appearance: AppearanceSettings = AppearanceSettings(),
)
