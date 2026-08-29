<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/runtime/AgentAppContext.kt
package alice.agents.agent.runtime
========
package io.github.mangi.eta.agent.runtime
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/runtime/AgentAppContext.kt

import android.content.Context

internal object AgentAppContext {
    fun resolve(): Context? {
        val activityThreadClass = runCatching {
            Class.forName("android.app.ActivityThread")
        }.getOrNull()
        runCatching {
            activityThreadClass
                ?.getDeclaredMethod("currentApplication")
                ?.apply { isAccessible = true }
                ?.invoke(null) as? Context
        }.getOrNull()?.let { return it.applicationContext ?: it }

        runCatching {
            Class.forName("android.app.AppGlobals")
                .getDeclaredMethod("getInitialApplication")
                .apply { isAccessible = true }
                .invoke(null) as? Context
        }.getOrNull()?.let { return it.applicationContext ?: it }

        return null
    }
}
