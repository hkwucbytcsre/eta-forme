<<<<<<<< HEAD:app/src/test/java/alice/agents/core/ModuleConfigEntryPackagesTest.kt
package alice.agents.core
========
package io.github.mangi.eta.core
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/core/ModuleConfigEntryPackagesTest.kt

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ModuleConfigEntryPackagesTest {
    @Test
    fun runtimeOnlyTrustsTheKnownAssistantEntryPackages() {
        assertEquals(
            setOf("com.heytap.speechassist", "com.miui.voiceassist"),
            ModuleConfig.AGENT_RUNTIME_ENTRY_PACKAGES,
        )
        assertTrue(ModuleConfig.XIAOAI_CORE_PROCESS.endsWith(":core"))
        assertEquals("com.oplus.aimemory", ModuleConfig.COLOROS_MEMORY_PACKAGE)
    }
}
