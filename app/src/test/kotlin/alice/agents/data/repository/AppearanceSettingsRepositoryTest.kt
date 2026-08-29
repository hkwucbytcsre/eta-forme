<<<<<<<< HEAD:app/src/test/java/alice/agents/data/repository/AppearanceSettingsRepositoryTest.kt
package alice.agents.data.repository

import alice.agents.FuckAndesApp
import alice.agents.data.datastore.SettingsDataStore
import alice.agents.data.model.AppearanceAccentColor
import alice.agents.data.model.AppearanceSettings
import alice.agents.data.model.AppearanceThemeMode
========
package io.github.mangi.eta.data.repository

import io.github.mangi.eta.EtaApp
import io.github.mangi.eta.data.datastore.SettingsDataStore
import io.github.mangi.eta.data.model.AppearanceAccentColor
import io.github.mangi.eta.data.model.AppearanceSettings
import io.github.mangi.eta.data.model.AppearanceThemeMode
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/data/repository/AppearanceSettingsRepositoryTest.kt
import java.util.UUID
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = EtaApp::class, sdk = [36])
class AppearanceSettingsRepositoryTest {
    @Test
    fun appearanceRoundTripPreservesExistingSettingsFields() = runBlocking {
        val before = SettingsDataStore.settings()
        val providerId = "provider-${UUID.randomUUID()}"
        val modelId = "model-${UUID.randomUUID()}"
        val appearance = AppearanceSettings(
            themeMode = AppearanceThemeMode.DARK,
            monetEnabled = true,
            accentColor = AppearanceAccentColor.TEAL,
            interfaceScale = 0.9f,
        )

        try {
            SettingsDataStore.updateSettings {
                it.copy(
                    selectedProviderId = providerId,
                    selectedModelId = modelId,
                    memoryEnabled = false,
                )
            }
            AppearanceSettingsRepository.update(appearance)

            assertEquals(appearance, AppearanceSettingsRepository.settingsFlow().first())
            val after = SettingsDataStore.settings()
            assertEquals(providerId, after.selectedProviderId)
            assertEquals(modelId, after.selectedModelId)
            assertEquals(false, after.memoryEnabled)
        } finally {
            SettingsDataStore.updateSettings { before }
        }
    }

    @Test
    fun transformUpdatesDoNotOverwriteEarlierAppearanceChanges() = runBlocking {
        val before = AppearanceSettingsRepository.settings()
        try {
            AppearanceSettingsRepository.update { it.copy(monetEnabled = true) }
            AppearanceSettingsRepository.update { it.copy(blurEnabled = false) }

            val actual = AppearanceSettingsRepository.settings()
            assertEquals(true, actual.monetEnabled)
            assertEquals(false, actual.blurEnabled)
        } finally {
            AppearanceSettingsRepository.update(before)
        }
    }
}
