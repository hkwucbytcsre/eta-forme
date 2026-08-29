<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/model/AgentToolsUiState.kt
package alice.agents.ui.model
========
package io.github.mangi.eta.ui.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/model/AgentToolsUiState.kt

import androidx.compose.runtime.Immutable

@Immutable
data class AgentToolsUiState(
    val groups: List<ToolGroupUi>,
)

@Immutable
data class ToolGroupUi(
    val id: String,
    val title: String,
    val tools: List<ToolItemUi>,
)

@Immutable
data class ToolItemUi(
    val id: String,
    val title: String,
    val summary: String,
)
