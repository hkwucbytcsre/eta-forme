<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/components/AdaptiveTopAppBar.kt
package alice.agents.ui.components
========
package io.github.mangi.eta.ui.components
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/components/AdaptiveTopAppBar.kt

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/components/AdaptiveTopAppBar.kt
import alice.agents.ui.layout.rememberIsWideScreen
========
import io.github.mangi.eta.ui.layout.rememberIsWideScreen
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/components/AdaptiveTopAppBar.kt
import top.yukonga.miuix.kmp.basic.ScrollBehavior
import top.yukonga.miuix.kmp.basic.SmallTopAppBar
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.theme.MiuixTheme

/** 宽屏固定小标题，手机使用可折叠大标题。 */
@Composable
fun AdaptiveTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    color: Color = MiuixTheme.colorScheme.surface,
    scrollBehavior: ScrollBehavior? = null,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    bottomContent: @Composable () -> Unit = {},
) {
    if (rememberIsWideScreen()) {
        SmallTopAppBar(
            title = title,
            modifier = modifier,
            color = color,
            scrollBehavior = scrollBehavior,
            navigationIcon = navigationIcon,
            actions = actions,
            bottomContent = bottomContent,
        )
    } else {
        TopAppBar(
            title = title,
            modifier = modifier,
            color = color,
            scrollBehavior = scrollBehavior,
            navigationIcon = navigationIcon,
            actions = actions,
            bottomContent = bottomContent,
        )
    }
}
