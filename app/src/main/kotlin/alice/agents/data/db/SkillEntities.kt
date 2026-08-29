<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/data/db/SkillEntities.kt
package alice.agents.data.db
========
package io.github.mangi.eta.data.db
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/data/db/SkillEntities.kt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skill_registry")
internal data class SkillRegistryEntity(
    @PrimaryKey @ColumnInfo(name = "skill_id") val skillId: String,
    val enabled: Boolean,
    val source: String,
    @ColumnInfo(name = "install_state") val installState: String,
)
