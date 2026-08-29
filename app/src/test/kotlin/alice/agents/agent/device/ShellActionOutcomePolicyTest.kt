<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/device/ShellActionOutcomePolicyTest.kt
package alice.agents.agent.device
========
package io.github.mangi.eta.agent.device
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/device/ShellActionOutcomePolicyTest.kt

import org.junit.Assert.assertEquals
import org.junit.Test

class ShellActionOutcomePolicyTest {
    @Test
    fun `process timeout is not treated as a definite command failure`() {
        assertEquals(
            ShellActionOutcomePolicy.Outcome.TIMED_OUT,
            ShellActionOutcomePolicy.classify(
                ShellActionOutcomePolicy.PROCESS_TIMEOUT_EXIT_CODE,
            ),
        )
    }

    @Test
    fun `zero and ordinary nonzero exit codes stay distinct`() {
        assertEquals(
            ShellActionOutcomePolicy.Outcome.SUCCEEDED,
            ShellActionOutcomePolicy.classify(0),
        )
        assertEquals(
            ShellActionOutcomePolicy.Outcome.FAILED,
            ShellActionOutcomePolicy.classify(1),
        )
    }
}
