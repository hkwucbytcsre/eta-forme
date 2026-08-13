package alice.agents.systemizer

import org.junit.Assert.assertEquals
import org.junit.Test

class GoogleAppSystemizerInstallerTest {

    @Test
    fun detectRootManagerUsesSuVersionForKernelSu() {
        val manager = GoogleAppSystemizerInstaller.detectRootManager(
            suVersionProbe = RootProbeResult(exitCode = 0, output = "v3.1.0:KernelSU"),
        )

        assertEquals(RootManager.KERNEL_SU, manager)
    }

    @Test
    fun detectRootManagerUsesSuVersionForMagisk() {
        val manager = GoogleAppSystemizerInstaller.detectRootManager(
            suVersionProbe = RootProbeResult(exitCode = 0, output = "30.7:MAGISKSU"),
        )

        assertEquals(RootManager.MAGISK, manager)
    }

    @Test
    fun detectRootManagerReturnsUnsupportedForUnknownSuVersion() {
        val manager = GoogleAppSystemizerInstaller.detectRootManager(
            suVersionProbe = RootProbeResult(exitCode = 0, output = "unknown"),
        )

        assertEquals(RootManager.UNSUPPORTED, manager)
    }
}