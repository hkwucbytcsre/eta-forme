<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/model/AgentHttpClient.kt
package alice.agents.agent.model
========
package io.github.mangi.eta.agent.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/model/AgentHttpClient.kt

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * 模块全局 OkHttp 客户端。
 *
 * 由所有 Provider 实现共享，避免重复创建连接池。超时设置与历史
 * HttpURLConnection 配置保持一致。
 */
internal object AgentHttpClient {

    private const val CONNECT_TIMEOUT_MS = 15_000L
    private const val READ_TIMEOUT_MS = 60_000L
    private const val WRITE_TIMEOUT_MS = 30_000L

    val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            .build()
    }
}
