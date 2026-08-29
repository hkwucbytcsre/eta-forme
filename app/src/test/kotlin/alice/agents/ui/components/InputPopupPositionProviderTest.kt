<<<<<<<< HEAD:app/src/test/java/alice/agents/ui/components/InputPopupPositionProviderTest.kt
package alice.agents.ui.components
========
package io.github.mangi.eta.ui.components
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/ui/components/InputPopupPositionProviderTest.kt

import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import org.junit.Assert.assertEquals
import org.junit.Test
import top.yukonga.miuix.kmp.basic.PopupPositionProvider

class InputPopupPositionProviderTest {
    @Test
    fun calculatePosition_alignsToWindowEndAboveInputContainer() {
        val result = InputPopupPositionProvider(
            inputContainerTopPx = 1_800,
            windowHorizontalInsetPx = 40,
        ).calculatePosition(
            anchorBounds = IntRect(left = 400, top = 1_850, right = 500, bottom = 1_900),
            windowBounds = IntRect(left = 0, top = 72, right = 1_080, bottom = 2_200),
            layoutDirection = LayoutDirection.Ltr,
            popupContentSize = IntSize(width = 300, height = 600),
            popupMargin = IntRect(left = 0, top = 24, right = 0, bottom = 24),
            alignment = PopupPositionProvider.Align.TopEnd,
        )

        assertEquals(740, result.x)
        assertEquals(1_176, result.y)
    }

    @Test
    fun calculatePosition_clampsToSafeWindowBounds() {
        val result = InputPopupPositionProvider(inputContainerTopPx = 300).calculatePosition(
            anchorBounds = IntRect(left = 80, top = 320, right = 160, bottom = 360),
            windowBounds = IntRect(left = 24, top = 72, right = 1_056, bottom = 2_200),
            layoutDirection = LayoutDirection.Ltr,
            popupContentSize = IntSize(width = 400, height = 500),
            popupMargin = IntRect(left = 0, top = 24, right = 0, bottom = 24),
            alignment = PopupPositionProvider.Align.TopEnd,
        )

        assertEquals(24, result.x)
        assertEquals(96, result.y)
    }
}
