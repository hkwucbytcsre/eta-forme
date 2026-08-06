package aki.agent.hook.system

import aki.agent.core.HookInstallation
import aki.agent.core.ModuleLogger

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
