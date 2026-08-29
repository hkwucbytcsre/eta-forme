<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/tool/ObservationReferencePolicy.kt
package alice.agents.agent.tool
========
package io.github.mangi.eta.agent.tool
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/tool/ObservationReferencePolicy.kt

internal object ObservationReferencePolicy {
    enum class Status {
        MATCH,
        NO_OBSERVATION,
        ID_REQUIRED,
        STALE,
    }

    fun validate(currentId: String?, requestedId: String?): Status = when {
        currentId == null -> Status.NO_OBSERVATION
        requestedId.isNullOrBlank() -> Status.ID_REQUIRED
        requestedId != currentId -> Status.STALE
        else -> Status.MATCH
    }
}
