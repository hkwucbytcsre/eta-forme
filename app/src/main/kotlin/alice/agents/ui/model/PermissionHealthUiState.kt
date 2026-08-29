<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/model/PermissionHealthUiState.kt
package alice.agents.ui.model
========
package io.github.mangi.eta.ui.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/model/PermissionHealthUiState.kt

import androidx.compose.runtime.Immutable

@Immutable
data class PermissionHealthUiState(
    val items: List<PermissionHealthItemUi>,
)

@Immutable
data class PermissionHealthItemUi(
    val id: String,
    val title: String,
    val summary: String,
    val status: PermissionStatusUi,
    val primaryActionLabel: String?,
)

@Immutable
enum class PermissionStatusUi {
    Available,
    Missing,
    Warning,
    Disabled,
}
