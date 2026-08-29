<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/device/GestureFallbackPolicyTest.kt
package alice.agents.agent.device
========
package io.github.mangi.eta.agent.device
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/device/GestureFallbackPolicyTest.kt

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class GestureFallbackPolicyTest {
    @Test
    fun `only a definitely undispatched gesture may be replayed`() {
        assertTrue(GestureFallbackPolicy.mayFallbackToRoot("GESTURE_NOT_DISPATCHED"))
        assertFalse(GestureFallbackPolicy.mayFallbackToRoot("GESTURE_CANCELLED"))
        assertFalse(GestureFallbackPolicy.mayFallbackToRoot("ACTION_OUTCOME_UNKNOWN"))
    }
}
