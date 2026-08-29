<<<<<<<< HEAD:app/src/test/java/alice/agents/ui/app/AgentRunRecoveryCoordinatorTest.kt
package alice.agents.ui.app

import alice.agents.agent.runtime.AgentRunCheckpointStore
import alice.agents.agent.runtime.AgentRuntimeWire
========
package io.github.mangi.eta.ui.app

import io.github.mangi.eta.agent.runtime.AgentRunCheckpointStore
import io.github.mangi.eta.agent.runtime.AgentRuntimeWire
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/ui/app/AgentRunRecoveryCoordinatorTest.kt
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class AgentRunRecoveryCoordinatorTest {
    @Test
    fun sameProcessActiveCheckpointIsReattached() {
        val plan = AgentRunRecoveryCoordinator.plan(
            checkpoints = listOf(checkpoint("run-active", owner = "same-process")),
            completedRuns = emptyList(),
            activeStateKnown = true,
            terminalStateKnown = true,
            activeRunId = "run-active",
            locallyObservedRunId = null,
        )

        assertEquals("run-active", plan.reattach?.runId)
        assertTrue(plan.interrupted.isEmpty())
    }

    @Test
    fun terminalResultTakesPrecedenceAndKeepsCheckpointForTraceReplay() {
        val checkpoint = checkpoint("run-complete")
        val completed = completed("run-complete")

        val plan = AgentRunRecoveryCoordinator.plan(
            checkpoints = listOf(checkpoint),
            completedRuns = listOf(completed),
            activeStateKnown = true,
            terminalStateKnown = true,
            activeRunId = "run-complete",
            locallyObservedRunId = null,
        )

        assertEquals(completed, plan.completed.single().result)
        assertEquals(checkpoint, plan.completed.single().checkpoint)
        assertNull(plan.reattach)
        assertTrue(plan.interrupted.isEmpty())
    }

    @Test
    fun inactiveCheckpointIsInterruptedButLocallyObservedRunIsIgnored() {
        val plan = AgentRunRecoveryCoordinator.plan(
            checkpoints = listOf(checkpoint("run-stale"), checkpoint("run-local")),
            completedRuns = emptyList(),
            activeStateKnown = true,
            terminalStateKnown = true,
            activeRunId = null,
            locallyObservedRunId = "run-local",
        )

        assertEquals(listOf("run-stale"), plan.interrupted.map { it.runId })
        assertNull(plan.reattach)
    }

    @Test
    fun unavailableRuntimeLeavesUnresolvedCheckpointUntouched() {
        val plan = AgentRunRecoveryCoordinator.plan(
            checkpoints = listOf(checkpoint("run-unknown")),
            completedRuns = emptyList(),
            activeStateKnown = false,
            terminalStateKnown = false,
            activeRunId = null,
            locallyObservedRunId = null,
        )

        assertTrue(plan.interrupted.isEmpty())
        assertNull(plan.reattach)
    }

    @Test
    fun knownActiveRunCanReattachEvenWhenTerminalQueryFailed() {
        val plan = AgentRunRecoveryCoordinator.plan(
            checkpoints = listOf(checkpoint("run-active"), checkpoint("run-unknown")),
            completedRuns = emptyList(),
            activeStateKnown = true,
            terminalStateKnown = false,
            activeRunId = "run-active",
            locallyObservedRunId = null,
        )

        assertEquals("run-active", plan.reattach?.runId)
        assertTrue(plan.interrupted.isEmpty())
    }

    private fun checkpoint(
        runId: String,
        owner: String = "old-process",
    ) = AgentRunCheckpointStore.Checkpoint(
        runId = runId,
        ownerInstanceId = owner,
        handoff = AgentRuntimeWire.EntryHandoff(
            id = runId,
            source = AgentRuntimeWire.AGENT_UI_HANDOFF_SOURCE,
            payload = "conversation-1",
        ),
        events = emptyList(),
        createdAt = 1L,
        updatedAt = 2L,
    )

    private fun completed(runId: String) = AgentRuntimeWire.CompletedRun(
        handoff = AgentRuntimeWire.EntryHandoff(
            id = runId,
            source = AgentRuntimeWire.AGENT_UI_HANDOFF_SOURCE,
            payload = "conversation-1",
        ),
        result = AgentRuntimeWire.RunResult(
            runId = runId,
            ok = true,
            content = "完成",
        ),
        createdAt = 3L,
    )
}
