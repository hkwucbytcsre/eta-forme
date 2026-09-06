package io.github.alice.eta

internal object AppProcessPolicy {
    fun shouldInitializeFullRuntime(processName: String, packageName: String): Boolean =
        processName == packageName
}
