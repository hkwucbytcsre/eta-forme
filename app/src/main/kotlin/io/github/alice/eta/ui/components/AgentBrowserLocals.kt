package io.github.alice.eta.ui.components

import androidx.compose.runtime.staticCompositionLocalOf
import io.github.alice.eta.agent.browser.AgentBrowserSession

internal val LocalAgentBrowserSession = staticCompositionLocalOf<AgentBrowserSession?> { null }
