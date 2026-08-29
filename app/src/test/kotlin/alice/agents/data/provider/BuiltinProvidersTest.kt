<<<<<<<< HEAD:app/src/test/java/alice/agents/data/provider/BuiltinProvidersTest.kt
package alice.agents.data.provider

import alice.agents.data.model.AnthropicProviderSetting
import alice.agents.data.model.OpenAiCompatibleProviderSetting
import alice.agents.data.model.OpenAiEndpointMode
import alice.agents.data.model.ProviderSourceTypes
========
package io.github.mangi.eta.data.provider

import io.github.mangi.eta.data.model.AnthropicProviderSetting
import io.github.mangi.eta.data.model.OpenAiCompatibleProviderSetting
import io.github.mangi.eta.data.model.OpenAiEndpointMode
import io.github.mangi.eta.data.model.ProviderSourceTypes
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/data/provider/BuiltinProvidersTest.kt
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BuiltinProvidersTest {
    @Test
    fun builtInsKeepStablePresetMetadataWithoutInliningModels() {
        val providers = BuiltinProviders.PROVIDERS.associateBy { it.id }

        assertTrue(providers[BuiltinProviders.OPENAI_ID] is OpenAiCompatibleProviderSetting)
        assertTrue(providers[BuiltinProviders.ANTHROPIC_ID] is AnthropicProviderSetting)
        assertEquals(0, providers.getValue(BuiltinProviders.OPENAI_ID).models.size)
        assertEquals(
            OpenAiEndpointMode.RESPONSES,
            (providers.getValue(BuiltinProviders.OPENAI_ID) as OpenAiCompatibleProviderSetting).endpointMode,
        )
        assertEquals(false, providers.getValue(BuiltinProviders.OPENAI_ID).hostedWebSearchEnabled)
        assertEquals(0, providers.getValue(BuiltinProviders.BAILIAN_ID).models.size)
        assertEquals(0, providers.getValue(BuiltinProviders.MIMO_ID).models.size)
        assertEquals(0, providers.getValue(BuiltinProviders.MINIMAX_ID).models.size)
        assertEquals(0, providers.getValue(BuiltinProviders.STEPFUN_ID).models.size)
        assertEquals("https://api.moonshot.cn/v1", providers.getValue(BuiltinProviders.KIMI_ID).baseUrl)
        assertEquals(ProviderSourceTypes.BAILIAN, providers.getValue(BuiltinProviders.BAILIAN_ID).sourceType)
        assertEquals(ProviderSourceTypes.MOONSHOT, providers.getValue(BuiltinProviders.KIMI_ID).sourceType)
        assertEquals(ProviderSourceTypes.MIMO, providers.getValue(BuiltinProviders.MIMO_ID).sourceType)
        assertEquals(ProviderSourceTypes.MINIMAX, providers.getValue(BuiltinProviders.MINIMAX_ID).sourceType)
        assertEquals(ProviderSourceTypes.STEPFUN, providers.getValue(BuiltinProviders.STEPFUN_ID).sourceType)
    }
}
