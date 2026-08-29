<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/components/MiuixDialogActions.kt
package alice.agents.ui.components
========
package io.github.mangi.eta.ui.components
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/components/MiuixDialogActions.kt

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.TextButton
import top.yukonga.miuix.kmp.theme.MiuixTheme
<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/components/MiuixDialogActions.kt
import alice.agents.R
========
import io.github.mangi.eta.R
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/components/MiuixDialogActions.kt

/**
 * 弹窗底部按钮行：取消在左、确认在右，平分整行。
 * 遵循 Miuix 官方示例的双按钮惯例，全 App 弹窗统一使用。
 *
 * @param confirmText 确认按钮文案。
 * @param onCancel 取消回调。
 * @param onConfirm 确认回调。
 * @param modifier 根修饰符。
 * @param cancelText 取消按钮文案。
 * @param cancelEnabled 取消按钮是否可用。
 * @param confirmEnabled 确认按钮是否可用。
 * @param destructive 确认是否为破坏性操作（使用 error 配色）。
 */
@Composable
fun MiuixDialogActions(
    confirmText: String,
    onCancel: () -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier,
    cancelText: String? = null,
    cancelEnabled: Boolean = true,
    confirmEnabled: Boolean = true,
    destructive: Boolean = false,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        TextButton(
            text = cancelText ?: stringResource(R.string.action_cancel),
            onClick = onCancel,
            enabled = cancelEnabled,
            modifier = Modifier.weight(1f),
        )
        TextButton(
            text = confirmText,
            onClick = onConfirm,
            enabled = confirmEnabled,
            modifier = Modifier.weight(1f),
            colors = if (destructive) {
                ButtonDefaults.textButtonColorsPrimary(
                    color = MiuixTheme.colorScheme.error,
                    textColor = MiuixTheme.colorScheme.onError,
                )
            } else {
                ButtonDefaults.textButtonColorsPrimary()
            },
        )
    }
}
