<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/model/AgentSkillsUiState.kt
package alice.agents.ui.model
========
package io.github.mangi.eta.ui.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/model/AgentSkillsUiState.kt

import androidx.compose.runtime.Immutable

@Immutable
data class AgentSkillsUiState(
    val skills: List<SkillItemUi> = emptyList(),
    val isLoading: Boolean = false,
    val isImporting: Boolean = false,
    val busySkillId: String? = null,
    val replacement: SkillReplacementUi? = null,
    val notice: SkillNoticeUi? = null,
)

@Immutable
data class SkillReplacementUi(
    val id: String,
    val name: String,
)

@Immutable
data class SkillNoticeUi(
    val id: Long,
    val title: String,
    val message: String,
    val isError: Boolean,
)

@Immutable
data class SkillItemUi(
    val id: String,
    val name: String,
    val description: String,
    val source: String,
    val enabled: Boolean,
    val installed: Boolean,
    val capabilities: List<String>,
)

internal val SkillItemUi.canDeleteUserSkill: Boolean
    get() = installed && source == "user"
