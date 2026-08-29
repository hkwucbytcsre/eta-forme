<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/data/model/CustomHeader.kt
package alice.agents.data.model
========
package io.github.mangi.eta.data.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/data/model/CustomHeader.kt

import kotlinx.serialization.Serializable

/**
 * Provider 或模型级别的自定义 HTTP Header。
 *
 * 注意：host / content-length / connection / transfer-encoding 等危险 header
 * 会在网络层被过滤，防止破坏 HTTP 协议。
 */
@Serializable
data class CustomHeader(
    val name: String,
    val value: String
)
