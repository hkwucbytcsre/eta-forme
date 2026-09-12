package io.github.alice.eta

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppProcessPolicyTest {
    @Test
    fun `仅主进程初始化完整 Runtime 依赖`() {
        assertTrue(AppProcessPolicy.shouldInitializeFullRuntime("io.github.alice.eta", "io.github.alice.eta"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("io.github.alice.eta:voice", "io.github.alice.eta"))
        assertFalse(AppProcessPolicy.shouldInitializeFullRuntime("io.github.alice.eta:voice_session", "io.github.alice.eta"))
    }
}
