<<<<<<<< HEAD:app/src/test/java/alice/agents/data/model/SettingsTest.kt
package alice.agents.data.model
========
package io.github.mangi.eta.data.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/data/model/SettingsTest.kt

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SettingsTest {
    @Test
    fun memoryIsEnabledByDefault() {
        assertTrue(Settings().memoryEnabled)
    }

    @Test
    fun appearanceUsesBackwardCompatibleDefaults() {
        assertEquals(AppearanceSettings(), Settings().appearance)
    }
}
