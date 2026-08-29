<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/hook/system/SystemServerHooks.kt
package alice.agents.hook.system

import alice.agents.core.HookInstallation
import alice.agents.core.ModuleLogger
========
package io.github.mangi.eta.hook.system

import io.github.mangi.eta.core.HookInstallation
import io.github.mangi.eta.core.ModuleLogger
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/hook/system/SystemServerHooks.kt

import io.github.libxposed.api.XposedModule

internal object SystemServerHooks {

    fun install(
        module: XposedModule,
        logger: ModuleLogger,
        classLoader: ClassLoader
    ): HookInstallation = HookInstallation.combine(
        group = "SystemServer",
        installations = listOf(
            AccessibilityProtectionHooks.install(module, logger, classLoader),
            ContextualSearchHooks.install(module, logger, classLoader),
            AssistantManager.install(module, logger, classLoader),
            HotwordSelfHealHooks.install(module, logger, classLoader),
            PowerHooks.install(module, logger, classLoader)
        )
    )
}
