<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/model/AgentSystemEnhanceUiState.kt
package alice.agents.ui.model
========
package io.github.mangi.eta.ui.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/model/AgentSystemEnhanceUiState.kt

import androidx.compose.runtime.Immutable

@Immutable
data class AgentSystemEnhanceUiState(
    val sections: List<SystemEnhanceSectionUi>,
)

@Immutable
data class SystemEnhanceSectionUi(
    val id: String,
    val title: String,
    val items: List<SystemEnhanceItemUi>,
)

@Immutable
data class SystemEnhanceItemUi(
    val id: String,
    val title: String,
    val summary: String,
    val status: SystemEnhanceStatusUi,
)

@Immutable
enum class SystemEnhanceStatusUi {
    Active,
    Inactive,
    Unsupported,
}
