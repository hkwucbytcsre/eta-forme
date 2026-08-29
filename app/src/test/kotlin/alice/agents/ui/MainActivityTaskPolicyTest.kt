<<<<<<<< HEAD:app/src/test/java/alice/agents/ui/MainActivityTaskPolicyTest.kt
package alice.agents.ui
========
package io.github.mangi.eta.ui
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/ui/MainActivityTaskPolicyTest.kt

import android.content.ComponentName
import android.content.pm.ActivityInfo
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class MainActivityTaskPolicyTest {
    @Suppress("DEPRECATION")
    @Test
    fun `主入口复用唯一任务实例`() {
        val context = RuntimeEnvironment.getApplication()
        val activityInfo = context.packageManager.getActivityInfo(
            ComponentName(context, MainActivity::class.java),
            0,
        )

        assertEquals(ActivityInfo.LAUNCH_SINGLE_TASK, activityInfo.launchMode)
    }
}
