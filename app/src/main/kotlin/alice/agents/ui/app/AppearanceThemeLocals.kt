<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/app/AppearanceThemeLocals.kt
package alice.agents.ui.app

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Density
import alice.agents.data.model.AppearanceSettings
import alice.agents.data.model.AppearanceTopBarBlurStyle
========
package io.github.mangi.eta.ui.app

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Density
import io.github.mangi.eta.data.model.AppearanceSettings
import io.github.mangi.eta.data.model.AppearanceTopBarBlurStyle
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/app/AppearanceThemeLocals.kt

internal val LocalAppearanceSettings = staticCompositionLocalOf { AppearanceSettings() }
internal val LocalBlurEnabled = staticCompositionLocalOf { true }
internal val LocalTopBarBlurStyle = staticCompositionLocalOf { AppearanceTopBarBlurStyle.GAUSSIAN }
internal val LocalPlatformDensity = staticCompositionLocalOf<Density?> { null }
