<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/accessibility/MainThreadCallGateTest.kt
package alice.agents.agent.accessibility
========
package io.github.mangi.eta.agent.accessibility
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/accessibility/MainThreadCallGateTest.kt

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MainThreadCallGateTest {
    @Test
    fun `cancelled pending action can never start later`() {
        val gate = MainThreadCallGate()

        assertTrue(gate.cancelIfPending())
        assertFalse(gate.tryStart())
        assertEquals(MainThreadCallGate.State.CANCELLED, gate.currentState())
    }

    @Test
    fun `running action cannot be reported as cancelled`() {
        val gate = MainThreadCallGate()

        assertTrue(gate.tryStart())
        assertFalse(gate.cancelIfPending())
        gate.finish()
        assertEquals(MainThreadCallGate.State.FINISHED, gate.currentState())
    }
}
