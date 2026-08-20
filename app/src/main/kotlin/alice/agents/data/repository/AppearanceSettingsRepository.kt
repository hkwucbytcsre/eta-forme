package alice.agents.data.repository

import alice.agents.data.datastore.SettingsDataStore
import alice.agents.data.model.AppearanceSettings
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
