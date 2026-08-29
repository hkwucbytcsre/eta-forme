<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/tool/ObservationReferencePolicyTest.kt
package alice.agents.agent.tool
========
package io.github.mangi.eta.agent.tool
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/tool/ObservationReferencePolicyTest.kt

import org.junit.Assert.assertEquals
import org.junit.Test

class ObservationReferencePolicyTest {
    @Test
    fun `requires an observation and its id`() {
        assertEquals(
            ObservationReferencePolicy.Status.NO_OBSERVATION,
            ObservationReferencePolicy.validate(null, "o1"),
        )
        assertEquals(
            ObservationReferencePolicy.Status.ID_REQUIRED,
            ObservationReferencePolicy.validate("o1", ""),
        )
    }

    @Test
    fun `publishing a newer observation rejects the old id`() {
        assertEquals(
            ObservationReferencePolicy.Status.STALE,
            ObservationReferencePolicy.validate("o2", "o1"),
        )
        assertEquals(
            ObservationReferencePolicy.Status.MATCH,
            ObservationReferencePolicy.validate("o2", "o2"),
        )
    }
}
