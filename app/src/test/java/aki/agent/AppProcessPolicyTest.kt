package aki.agent

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppProcessPolicyTest {
    @Test
    fun `仅主进程初始化完整 Runtime 依赖`() {
        assertTrue(AppProcessPolicy.shouldInitializeFullRuntime("aki.agent", "aki.agent"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("aki.agent:voice", "aki.agent"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("aki.agent:voice_session", "aki.agent"))
    }
}
