<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/model/AgentScreenObservationContractTest.kt
package alice.agents.agent.model
========
package io.github.mangi.eta.agent.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/model/AgentScreenObservationContractTest.kt

import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AgentScreenObservationContractTest {
    @Test
    fun emptyArgumentsPreferUiTreeWithoutScreenshot() {
        val options = AgentScreenObservationContract.resolve(JSONObject())

        assertFalse(options.includeScreenshot)
        assertTrue(options.includeUiTree)
        assertEquals(60, options.maxNodes)
    }

    @Test
    fun explicitScreenshotKeepsUiTreeEnabledByDefault() {
        val options = AgentScreenObservationContract.resolve(
            JSONObject().put("include_screenshot", true),
        )

        assertTrue(options.includeScreenshot)
        assertTrue(options.includeUiTree)
        assertEquals(60, options.maxNodes)
    }

    @Test
    fun explicitArgumentsOverrideEveryDefault() {
        val options = AgentScreenObservationContract.resolve(
            JSONObject()
                .put("include_screenshot", true)
                .put("include_ui_tree", false)
                .put("max_nodes", 120),
        )

        assertTrue(options.includeScreenshot)
        assertFalse(options.includeUiTree)
        assertEquals(120, options.maxNodes)
    }
}
