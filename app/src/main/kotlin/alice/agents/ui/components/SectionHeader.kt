<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/components/SectionHeader.kt
package alice.agents.ui.components
========
package io.github.mangi.eta.ui.components
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/components/SectionHeader.kt

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import top.yukonga.miuix.kmp.basic.SmallTitle

@Composable
fun SectionHeader(
    text: String,
    modifier: Modifier = Modifier,
) {
    SmallTitle(
        text = text,
        modifier = modifier,
    )
}
