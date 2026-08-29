<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/device/FocusedWindowParser.kt
package alice.agents.agent.device
========
package io.github.mangi.eta.agent.device
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/device/FocusedWindowParser.kt

/** 从 dumpsys window 中提取精确前台包，避免 `contains` 把相似包名判成同一 App。 */
internal object FocusedWindowParser {
    data class Result(
        val packageName: String,
        val component: String,
        val rawLine: String,
    )

    fun parse(output: String): Result? {
        val lines = output.lineSequence().map(String::trim).toList()
        val candidates = sequenceOf("mCurrentFocus=", "mFocusedApp=")
            .flatMap { marker -> lines.asSequence().filter { line -> marker in line } }
        for (line in candidates) {
            if (line.substringAfter('=', "").trim().startsWith("null")) continue
            val component = COMPONENT.find(line)?.value ?: continue
            return Result(
                packageName = component.substringBefore('/'),
                component = component,
                rawLine = line,
            )
        }
        return null
    }

    private val COMPONENT = Regex("""[A-Za-z0-9_]+(?:\.[A-Za-z0-9_]+)+/[A-Za-z0-9_.$]+""")
}
