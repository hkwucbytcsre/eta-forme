<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/app/AgentAppViewModel.kt
package alice.agents.ui.app
========
package io.github.mangi.eta.ui.app
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/app/AgentAppViewModel.kt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope

/** Activity 级状态所有者；配置变更只重建 UI，不替换正在运行的 Agent 会话。 */
internal class AgentAppViewModel(application: Application) : AndroidViewModel(application) {
    val state = AgentAppState(
        context = application,
        scope = viewModelScope,
    )
}
