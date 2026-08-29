<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/terminal/ShellProcessSupervisorTest.kt
package alice.agents.agent.terminal
========
package io.github.mangi.eta.agent.terminal
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/terminal/ShellProcessSupervisorTest.kt

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ShellProcessSupervisorTest {
    @Test
    fun missingSetsidFailsClosedWhenTreeFallbackIsDisabled() {
        val supervisor = ShellProcessSupervisor(
            allowTreeFallback = false,
            setsidCommand = "eta-test-missing-setsid",
        )

        val process = supervisor.startShellProcess(
            identity = "user",
            command = "echo should-not-run",
            mergeStderr = false,
        )

        assertNull(process)
    }

    @Test
    fun rootAndroidPayloadUsesDiscoveredBusyBoxWithoutChangingUserShell() {
        val supervisor = ShellProcessSupervisor()

        val rootPayload = supervisor.buildAndroidPayload("root", "command -v xz")
        val userPayload = supervisor.buildAndroidPayload("user", "id")

        assertTrue(rootPayload.contains("/data/adb/magisk/busybox"))
        assertTrue(rootPayload.contains("ASH_STANDALONE=1"))
        assertEquals("sh -c 'id'", userPayload)
    }

    @Test
    fun linuxPayloadKeepsShellQuotesAndMountsPrivateExchangeDirectory() {
        val supervisor = ShellProcessSupervisor()

        val payload = supervisor.buildLinuxPayload(
<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/terminal/ShellProcessSupervisorTest.kt
            rootfsPath = "/data/user/0/alice.agents/files/terminal/alpine/rootfs",
========
            rootfsPath = "/data/user/0/io.github.mangi.eta/files/terminal/alpine/rootfs",
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/terminal/ShellProcessSupervisorTest.kt
            command = "printf '%s' \"hello\"",
        )

        assertFalse(payload.contains("\\\""))
        assertTrue(payload.contains("unshare -m --propagation private"))
        assertTrue(payload.contains("mount -t proc"))
        assertTrue(payload.contains("eta_mount_required /data/local/tmp"))
        assertTrue(payload.contains("eta_mount_required /data/local/tmp/eta"))
        assertTrue(payload.contains("eta_rootfs/workspace"))
        assertTrue(payload.contains("chroot"))
        assertTrue(payload.contains(AlpineEnvironmentPaths.READY_MARKER))
    }
}
