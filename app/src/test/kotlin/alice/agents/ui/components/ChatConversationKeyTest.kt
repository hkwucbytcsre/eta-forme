<<<<<<<< HEAD:app/src/test/java/alice/agents/ui/components/ChatConversationKeyTest.kt
package alice.agents.ui.components
========
package io.github.mangi.eta.ui.components
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/ui/components/ChatConversationKeyTest.kt

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class ChatConversationKeyTest {
    @Test
    fun sameConversationKeepsTheSameCompositionKey() {
        assertEquals(
            chatConversationCompositionKey("conversation-1"),
            chatConversationCompositionKey("conversation-1"),
        )
    }

    @Test
    fun switchingConversationChangesTheCompositionKey() {
        assertNotEquals(
            chatConversationCompositionKey("conversation-1"),
            chatConversationCompositionKey("conversation-2"),
        )
    }

    @Test
    fun draftConversationHasAStableNonNullKey() {
        assertEquals("conversation:draft", chatConversationCompositionKey(null))
    }
}
