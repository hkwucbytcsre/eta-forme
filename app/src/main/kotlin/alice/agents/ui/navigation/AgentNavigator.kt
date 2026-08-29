<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/navigation/AgentNavigator.kt
package alice.agents.ui.navigation
========
package io.github.mangi.eta.ui.navigation
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/navigation/AgentNavigator.kt

import top.yukonga.miuix.kmp.nav.core.NavBackStack
import top.yukonga.miuix.kmp.nav.core.NavKey

class AgentNavigator(
    val backStack: NavBackStack,
) {
    fun push(route: AppRoute) {
        if (route !in backStack) {
            backStack.add(route)
        }
    }

    fun replace(route: AppRoute) {
        val existingIndex = backStack.indexOf(route)
        if (existingIndex >= 0) {
            while (backStack.lastIndex > existingIndex) {
                backStack.removeLastOrNull()
            }
            return
        }

        if (backStack.isNotEmpty()) {
            backStack[backStack.lastIndex] = route
        } else {
            backStack.add(route)
        }
    }

    fun pop(): Boolean {
        if (backStack.size <= 1) return false
        backStack.removeLastOrNull()
        return true
    }

    fun popToHome() {
        while (backStack.size > 1) {
            backStack.removeLastOrNull()
        }
        backStack.firstOrNull()?.let { first ->
            if (first !is AppRoute.Home) {
                backStack.clear()
                backStack.add(AppRoute.Home)
            }
        }
    }

    fun current(): NavKey? = backStack.lastOrNull()
}
