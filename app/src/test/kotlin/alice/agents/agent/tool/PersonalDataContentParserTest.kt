<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/tool/PersonalDataContentParserTest.kt
package alice.agents.agent.tool
========
package io.github.mangi.eta.agent.tool
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/tool/PersonalDataContentParserTest.kt

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PersonalDataContentParserTest {
    @Test
    fun `provider exception is not treated as an empty result`() {
        assertTrue(
            PersonalDataContentParser.hasProviderFailure(
                stdout = "",
                stderr = "Error while accessing provider:media\njava.lang.IllegalArgumentException: Invalid column display_name",
            ),
        )
        assertFalse(
            PersonalDataContentParser.hasProviderFailure(
                stdout = "No result found.",
                stderr = "",
            ),
        )
    }

    @Test
    fun parsesOnlyDeclaredColumnsWithoutSplittingMessageBody() {
        val rows = PersonalDataContentParser.parseRows(
            "Row: 0 _id=7, address=1069, body=会议地点改到 A, B 两区, date=123",
            listOf("_id", "address", "body", "date"),
        )

        assertEquals(1, rows.size)
        assertEquals("会议地点改到 A, B 两区", rows.single().getString("body"))
        assertEquals("123", rows.single().getString("date"))
        assertFalse(rows.single().has("unknown"))
    }
}
