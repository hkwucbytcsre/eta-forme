<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/components/MiuixBackButton.kt
package alice.agents.ui.components
========
package io.github.mangi.eta.ui.components
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/components/MiuixBackButton.kt

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/components/MiuixBackButton.kt
import alice.agents.R
========
import io.github.mangi.eta.R
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/components/MiuixBackButton.kt
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Back

/**
 * 二级页面统一返回按钮，保持图标、语义、RTL 方向与点击区域一致。
 */
@Composable
fun MiuixBackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val layoutDirection = LocalLayoutDirection.current
    IconButton(onClick = onClick, modifier = modifier) {
        Icon(
            imageVector = MiuixIcons.Back,
            contentDescription = stringResource(R.string.action_back),
            modifier = Modifier.graphicsLayer {
                scaleX = if (layoutDirection == LayoutDirection.Rtl) -1f else 1f
            },
        )
    }
}
