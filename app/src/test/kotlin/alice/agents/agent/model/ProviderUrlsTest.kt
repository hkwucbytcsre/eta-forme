<<<<<<<< HEAD:app/src/test/java/alice/agents/agent/model/ProviderUrlsTest.kt
package alice.agents.agent.model
========
package io.github.mangi.eta.agent.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/agent/model/ProviderUrlsTest.kt

import org.junit.Assert.assertEquals
import org.junit.Test

class ProviderUrlsTest {
    @Test
    fun appendsProviderSpecificPathsToRootBaseUrl() {
        assertEquals(
            "https://api.openai.com/v1/chat/completions",
            ProviderUrls.openAiChatCompletionsUrl("https://api.openai.com/v1/")
        )
        assertEquals(
            "https://api.openai.com/v1/models",
            ProviderUrls.openAiModelsUrl("https://api.openai.com/v1")
        )
        assertEquals(
            "https://api.openai.com/v1/responses",
            ProviderUrls.openAiResponsesUrl("https://api.openai.com/v1/")
        )
        assertEquals(
            "https://api.anthropic.com/v1/messages",
            ProviderUrls.anthropicMessagesUrl("https://api.anthropic.com/")
        )
        assertEquals(
            "https://api.anthropic.com/v1/models",
            ProviderUrls.anthropicModelsUrl("https://api.anthropic.com")
        )
    }
}
