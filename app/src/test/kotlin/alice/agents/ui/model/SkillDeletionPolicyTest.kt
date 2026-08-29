<<<<<<<< HEAD:app/src/test/java/alice/agents/ui/model/SkillDeletionPolicyTest.kt
package alice.agents.ui.model
========
package io.github.mangi.eta.ui.model
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/ui/model/SkillDeletionPolicyTest.kt

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SkillDeletionPolicyTest {
    @Test
    fun onlyInstalledUserSkillsCanBeDeleted() {
        assertTrue(skill(source = "user", installed = true).canDeleteUserSkill)
        assertFalse(skill(source = "builtin", installed = true).canDeleteUserSkill)
        assertFalse(skill(source = "user", installed = false).canDeleteUserSkill)
        assertFalse(skill(source = "unknown", installed = true).canDeleteUserSkill)
    }

    private fun skill(source: String, installed: Boolean) = SkillItemUi(
        id = "test-skill",
        name = "Test Skill",
        description = "Test deletion policy.",
        source = source,
        enabled = true,
        installed = installed,
        capabilities = emptyList(),
    )
}
