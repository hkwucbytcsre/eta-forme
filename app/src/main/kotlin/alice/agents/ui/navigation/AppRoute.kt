<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/navigation/AppRoute.kt
package alice.agents.ui.navigation
========
package io.github.mangi.eta.ui.navigation
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/navigation/AppRoute.kt

import kotlinx.serialization.Serializable
import top.yukonga.miuix.kmp.nav.core.NavKey

@Serializable
sealed interface AppRoute : NavKey {
    @Serializable
    data object Home : AppRoute

    @Serializable
    data object Chat : AppRoute

    @Serializable
    data object Browser : AppRoute

    @Serializable
    data object Tools : AppRoute

    @Serializable
    data object Skills : AppRoute

    @Serializable
    data object Permissions : AppRoute

    @Serializable
    data object SystemEnhance : AppRoute

    @Serializable
    data object Settings : AppRoute

    @Serializable
    data object AppearanceSettings : AppRoute

    @Serializable
    data object DataBackup : AppRoute

    @Serializable
    data object Memory : AppRoute

    @Serializable
    data object LinuxEnvironment : AppRoute

    @Serializable
    data object ModelProviders : AppRoute

    @Serializable
    data object McpServers : AppRoute

    @Serializable
    data class McpServerDetail(val serverId: String) : AppRoute

    @Serializable
    data class ModelProviderDetail(val providerId: String) : AppRoute

    @Serializable
    data class ModelProviderNew(val type: NewProviderType) : AppRoute
}

@Serializable
enum class NewProviderType { OpenAiCompatible, Anthropic }
