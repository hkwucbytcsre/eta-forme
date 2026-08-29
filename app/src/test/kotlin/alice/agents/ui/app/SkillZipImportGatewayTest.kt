<<<<<<<< HEAD:app/src/test/java/alice/agents/ui/app/SkillZipImportGatewayTest.kt
package alice.agents.ui.app

import alice.agents.agent.skill.InstalledSkill
import alice.agents.agent.skill.SkillInstallConflict
import alice.agents.agent.skill.SkillInstallErrorCode
import alice.agents.agent.skill.SkillInstallResult
========
package io.github.mangi.eta.ui.app

import io.github.mangi.eta.agent.skill.InstalledSkill
import io.github.mangi.eta.agent.skill.SkillInstallConflict
import io.github.mangi.eta.agent.skill.SkillInstallErrorCode
import io.github.mangi.eta.agent.skill.SkillInstallResult
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/ui/app/SkillZipImportGatewayTest.kt
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SkillZipImportGatewayTest {

    @Test
    fun `success keeps display metadata only`() {
        val outcome = SkillInstallResult.Success(
            installed = listOf(
                InstalledSkill(
                    id = "example",
                    name = "Example",
                    description = "description",
                ),
            ),
        ).toZipImportOutcome()

        assertTrue(outcome is SkillZipImportOutcome.Success)
        val success = outcome as SkillZipImportOutcome.Success
        assertEquals(
            listOf(SkillZipImportOutcome.InstalledSkill(id = "example", name = "Example")),
            success.skills,
        )
    }

    @Test
    fun `conflict preserves replacement policy`() {
        val outcome = SkillInstallResult.Conflict(
            conflicts = listOf(
                SkillInstallConflict(
                    id = "builtin",
                    name = "Builtin",
                    existingSource = "builtin",
                    replaceAllowed = false,
                ),
            ),
            archiveSha256 = "a".repeat(64),
        ).toZipImportOutcome()

        assertTrue(outcome is SkillZipImportOutcome.Conflict)
        val conflict = (outcome as SkillZipImportOutcome.Conflict).skills.single()
        assertEquals("builtin", conflict.source)
        assertFalse(conflict.replaceAllowed)
        assertEquals("a".repeat(64), outcome.archiveSha256)
    }

    @Test
    fun `core errors map to bounded user facing categories`() {
        assertEquals(
            SkillZipImportOutcome.FailureCode.ARCHIVE_LIMIT_EXCEEDED,
            SkillInstallErrorCode.EXTRACTED_CONTENT_TOO_LARGE.toUiFailureCode(),
        )
        assertEquals(
            SkillZipImportOutcome.FailureCode.UNSAFE_ARCHIVE,
            SkillInstallErrorCode.UNSAFE_ENTRY_PATH.toUiFailureCode(),
        )
        assertEquals(
            SkillZipImportOutcome.FailureCode.TARGET_NOT_REPLACEABLE,
            SkillInstallErrorCode.TARGET_NOT_REPLACEABLE.toUiFailureCode(),
        )
        assertEquals(
            SkillZipImportOutcome.FailureCode.PACKAGE_CHANGED,
            SkillInstallErrorCode.INVALID_SELECTION.toUiFailureCode(),
        )
    }

    @Test
    fun `incomplete rollback maps to recovery required`() {
        val outcome = SkillInstallResult.Failure(
<<<<<<<< HEAD:app/src/test/java/alice/agents/ui/app/SkillZipImportGatewayTest.kt
            error = alice.agents.agent.skill.SkillInstallError(
========
            error = io.github.mangi.eta.agent.skill.SkillInstallError(
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/test/kotlin/io/github/mangi/eta/ui/app/SkillZipImportGatewayTest.kt
                code = SkillInstallErrorCode.COMMIT_FAILED,
                message = "rollback incomplete",
            ),
            recoveryRequired = true,
        ).toZipImportOutcome()

        assertEquals(
            SkillZipImportOutcome.FailureCode.RECOVERY_REQUIRED,
            (outcome as SkillZipImportOutcome.Failure).code,
        )
    }
}
