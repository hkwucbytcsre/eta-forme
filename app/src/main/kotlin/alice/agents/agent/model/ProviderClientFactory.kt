<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/model/ProviderClientFactory.kt
package alice.agents.agent.model

import alice.agents.data.model.ProviderTypes
import alice.agents.data.model.OpenAiEndpointMode
========
package io.github.mangi.eta.agent.model

import io.github.mangi.eta.data.model.ProviderTypes
import io.github.mangi.eta.data.model.OpenAiEndpointMode
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/model/ProviderClientFactory.kt

internal object ProviderClientFactory {

    fun getClient(config: AgentModelClient.ModelConfig): AgentProviderClient =
        when (config.providerType) {
            ProviderTypes.OPENAI_COMPATIBLE -> when (config.openAiEndpointMode) {
                OpenAiEndpointMode.RESPONSES -> OpenAiResponsesProvider
                else -> OpenAiChatCompletionsProvider
            }
            ProviderTypes.ANTHROPIC -> AnthropicMessagesProvider
            else -> error("不支持的 Provider 协议类型：${config.providerType}")
        }
}
