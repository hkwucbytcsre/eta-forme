package alice.agents

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppProcessPolicyTest {
    @Test
    fun `仅主进程初始化完整 Runtime 依赖`() {
        assertTrue(AppProcessPolicy.shouldInitializeFullRuntime("alice.agents", "alice.agents"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("alice.agents:voice", "alice.agents"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("alice.agents:voice_session", "alice.agents"))
    }
}
