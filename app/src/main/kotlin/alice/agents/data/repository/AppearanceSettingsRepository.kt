<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/data/repository/AppearanceSettingsRepository.kt
package alice.agents.data.repository

import alice.agents.data.datastore.SettingsDataStore
import alice.agents.data.model.AppearanceSettings
========
package io.github.mangi.eta.data.repository

import io.github.mangi.eta.data.datastore.SettingsDataStore
import io.github.mangi.eta.data.model.AppearanceSettings
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/data/repository/AppearanceSettingsRepository.kt
import kotlinx.coroutines.flow.Flow

object AppearanceSettingsRepository {
    fun settingsFlow(): Flow<AppearanceSettings> = SettingsDataStore.appearanceSettingsFlow()

    suspend fun settings(): AppearanceSettings = SettingsDataStore.settings().appearance

    suspend fun update(settings: AppearanceSettings) {
        SettingsDataStore.setAppearanceSettings(settings)
    }

    suspend fun update(transform: (AppearanceSettings) -> AppearanceSettings) {
        SettingsDataStore.updateAppearanceSettings(transform)
    }
}
