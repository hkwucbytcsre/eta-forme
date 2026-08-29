<<<<<<<< HEAD:app/src/test/java/alice/agents/AppProcessPolicyTest.kt
package alice.agents
========
package io.github.mangi.eta
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/AppProcessPolicyTest.kt

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppProcessPolicyTest {
    @Test
    fun `仅主进程初始化完整 Runtime 依赖`() {
<<<<<<<< HEAD:app/src/test/java/alice/agents/AppProcessPolicyTest.kt
        assertTrue(AppProcessPolicy.shouldInitializeFullRuntime("alice.agents", "alice.agents"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("alice.agents:voice", "alice.agents"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("alice.agents:voice_session", "alice.agents"))
========
        assertTrue(AppProcessPolicy.shouldInitializeFullRuntime("io.github.mangi.eta", "io.github.mangi.eta"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("io.github.mangi.eta:voice", "io.github.mangi.eta"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("io.github.mangi.eta:voice_session", "io.github.mangi.eta"))
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/AppProcessPolicyTest.kt
    }
}
