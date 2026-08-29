<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/device/AndroidDisplaySizeParserTest.kt
package alice.agents.agent.device
========
package io.github.mangi.eta.agent.device
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/device/AndroidDisplaySizeParserTest.kt

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class AndroidDisplaySizeParserTest {
    @Test
    fun `override logical size wins over physical panel size`() {
        assertEquals(
            1080 to 2412,
            AndroidDisplaySizeParser.parse(
                """
                Physical size: 1440x3216
                Override size: 1080x2412
                """.trimIndent(),
            ),
        )
    }

    @Test
    fun `physical size is used when no override exists`() {
        assertEquals(
            1264 to 2780,
            AndroidDisplaySizeParser.parse("Physical size: 1264x2780"),
        )
    }

    @Test
    fun `invalid output is rejected`() {
        assertNull(AndroidDisplaySizeParser.parse("permission denied"))
    }
}
