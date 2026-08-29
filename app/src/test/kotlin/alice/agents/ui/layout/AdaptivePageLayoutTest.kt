<<<<<<<< HEAD:app/src/test/java/alice/agents/ui/layout/AdaptivePageLayoutTest.kt
package alice.agents.ui.layout
========
package io.github.mangi.eta.ui.layout
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/ui/layout/AdaptivePageLayoutTest.kt

import androidx.compose.ui.unit.Density
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AdaptivePageLayoutTest {
    @Test
    fun wideScreenDecisionUsesTheProvidedUnscaledDensity() {
        val widthPx = 1200

        assertTrue(isWideScreen(widthPx, Density(density = 2f)))
        assertFalse(isWideScreen(widthPx, Density(density = 2.2f)))
    }
}
