<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/ui/app/PredictiveBackController.kt
package alice.agents.ui.app

import android.content.pm.ApplicationInfo
import android.os.Build
import alice.agents.core.AndroidAgentLogger
========
package io.github.mangi.eta.ui.app

import android.content.pm.ApplicationInfo
import android.os.Build
import io.github.mangi.eta.core.AndroidAgentLogger
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/ui/app/PredictiveBackController.kt
import org.lsposed.hiddenapibypass.HiddenApiBypass

internal object PredictiveBackController {
    private const val METHOD_NAME = "setEnableOnBackInvokedCallback"

    fun apply(applicationInfo: ApplicationInfo, enabled: Boolean): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.UPSIDE_DOWN_CAKE) return true
        return runCatching {
            HiddenApiBypass.addHiddenApiExemptions(
                "Landroid/content/pm/ApplicationInfo;->$METHOD_NAME",
            )
            ApplicationInfo::class.java.getDeclaredMethod(
                METHOD_NAME,
                Boolean::class.javaPrimitiveType,
            ).apply {
                isAccessible = true
                invoke(applicationInfo, enabled)
            }
        }.fold(
            onSuccess = { true },
            onFailure = {
                AndroidAgentLogger.warn("Predictive back setting could not be applied")
                false
            },
        )
    }
}
