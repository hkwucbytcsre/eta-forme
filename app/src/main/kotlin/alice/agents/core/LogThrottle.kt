<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/core/LogThrottle.kt
package alice.agents.core
========
package io.github.mangi.eta.core
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/core/LogThrottle.kt

import android.os.SystemClock
import java.util.concurrent.ConcurrentHashMap

/** 进程内日志节流器；使用单调时钟，不受系统时间调整影响。 */
internal class LogThrottle(
    private val uptimeMillis: () -> Long = SystemClock::uptimeMillis
) {
    private val lastAcceptedAt = ConcurrentHashMap<String, Long>()

    fun shouldLog(key: String, windowMs: Long): Boolean {
        require(key.isNotBlank()) { "日志节流 key 不能为空" }
        require(windowMs >= 0L) { "日志节流窗口不能为负数" }

        val now = uptimeMillis()
        var accepted = false
        lastAcceptedAt.compute(key) { _, previous ->
            if (previous == null || now < previous || now - previous >= windowMs) {
                accepted = true
                now
            } else {
                previous
            }
        }
        return accepted
    }
}
