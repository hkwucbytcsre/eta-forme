<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/model/AgentMemoryUiState.kt
package alice.agents.ui.model

import androidx.compose.runtime.Immutable
import alice.agents.data.repository.AgentMemoryStore
========
package io.github.mangi.eta.ui.model

import androidx.compose.runtime.Immutable
import io.github.mangi.eta.data.repository.AgentMemoryStore
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/model/AgentMemoryUiState.kt

@Immutable
data class AgentMemoryUiState(
    val enabled: Boolean = true,
    val isLoading: Boolean = true,
    val isSaving: Boolean = false,
    val draft: String = "",
    val savedContent: String = "",
    val draftBytes: Int = 0,
    val maxBytes: Int = AgentMemoryStore.MAX_FILE_BYTES,
    val coreBudgetChars: Int = 8_000,
    val notice: String? = null,
) {
    val hasUnsavedChanges: Boolean get() = draft != savedContent
    val canSave: Boolean
        get() = !isLoading && !isSaving && hasUnsavedChanges &&
            draftBytes <= maxBytes
}
