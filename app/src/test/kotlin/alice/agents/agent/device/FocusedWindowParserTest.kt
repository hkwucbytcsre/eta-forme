<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/device/FocusedWindowParserTest.kt
package alice.agents.agent.device
========
package io.github.mangi.eta.agent.device
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/device/FocusedWindowParserTest.kt

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class FocusedWindowParserTest {
    @Test
    fun `uses focused app when current focus is null`() {
        val parsed = FocusedWindowParser.parse(
            """
            mCurrentFocus=null
            mFocusedApp=ActivityRecord{abc u0 com.example.app/.MainActivity t42}
            """.trimIndent(),
        )

        assertEquals("com.example.app", parsed?.packageName)
        assertEquals("com.example.app/.MainActivity", parsed?.component)
    }

    @Test
    fun `similar package names remain distinct`() {
        val parsed = FocusedWindowParser.parse(
            "mCurrentFocus=Window{abc u0 com.foobar/.MainActivity}",
        )

        assertEquals("com.foobar", parsed?.packageName)
    }

    @Test
    fun `missing focus returns null`() {
        assertNull(FocusedWindowParser.parse("WINDOW MANAGER WINDOWS"))
    }
}
