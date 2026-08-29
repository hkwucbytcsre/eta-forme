<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/screens/enhance/SystemEnhanceScreen.kt
package alice.agents.ui.screens.enhance
import alice.agents.R
========
package io.github.mangi.eta.ui.screens.enhance
import io.github.mangi.eta.R
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/screens/enhance/SystemEnhanceScreen.kt
import androidx.compose.ui.res.stringResource

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/screens/enhance/SystemEnhanceScreen.kt
import alice.agents.ui.components.MiuixScaffoldPage
import alice.agents.ui.model.AgentSystemEnhanceAction
import alice.agents.ui.model.AgentSystemEnhanceUiState
import alice.agents.ui.model.SystemEnhanceItemUi
import alice.agents.ui.model.SystemEnhanceStatusUi
========
import io.github.mangi.eta.ui.components.MiuixScaffoldPage
import io.github.mangi.eta.ui.model.AgentSystemEnhanceAction
import io.github.mangi.eta.ui.model.AgentSystemEnhanceUiState
import io.github.mangi.eta.ui.model.SystemEnhanceItemUi
import io.github.mangi.eta.ui.model.SystemEnhanceStatusUi
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/screens/enhance/SystemEnhanceScreen.kt
import top.yukonga.miuix.kmp.basic.BasicComponent
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun SystemEnhanceScreen(
    state: AgentSystemEnhanceUiState,
    onAction: (AgentSystemEnhanceAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    MiuixScaffoldPage(
        title = stringResource(R.string.ui_system_enhancement_dcd4ad),
        onBack = { onAction(AgentSystemEnhanceAction.NavigateBack) },
        modifier = modifier,
    ) {
        items(
            items = state.sections,
            key = { it.id },
        ) { section ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                ) {
                SmallTitle(
                    text = section.title,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                )
                section.items.forEach { item ->
                    SystemEnhanceItemRow(
                        item = item,
                        onToggle = { onAction(AgentSystemEnhanceAction.ToggleItem(item.id)) },
                    )
                }
            }
        }
    }
}

@Composable
private fun SystemEnhanceItemRow(
    item: SystemEnhanceItemUi,
    onToggle: () -> Unit,
) {
    BasicComponent(
        title = item.title,
        summary = item.summary,
        endActions = {
            Text(
                text = when (item.status) {
                    SystemEnhanceStatusUi.Active -> stringResource(R.string.status_enabled)
                    SystemEnhanceStatusUi.Inactive -> stringResource(R.string.permission_status_disabled)
                    SystemEnhanceStatusUi.Unsupported -> stringResource(R.string.status_unsupported)
                },
                style = MiuixTheme.textStyles.body2,
                color = MiuixTheme.colorScheme.onSurfaceVariantActions,
            )
        },
        onClick = onToggle,
    )
}
