<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/device/AgentNotificationHistoryService.kt
package alice.agents.agent.device
========
package io.github.mangi.eta.agent.device
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/device/AgentNotificationHistoryService.kt

import android.app.Notification
import android.content.ComponentName
import android.content.Context
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
<<<<<<<< HEAD:app/src/main/kotlin/alice/agents/agent/device/AgentNotificationHistoryService.kt
import alice.agents.data.repository.NotificationHistoryRepository
========
import io.github.mangi.eta.data.repository.NotificationHistoryRepository
>>>>>>>> feb618c (refactor(package): 将历史包名更名为 Eta):app/src/main/kotlin/io/github/mangi/eta/agent/device/AgentNotificationHistoryService.kt

class AgentNotificationHistoryService : NotificationListenerService() {
    private val repository by lazy { NotificationHistoryRepository(this) }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        record(sbn)
    }

    override fun onListenerConnected() {
        super.onListenerConnected()
        activeNotifications?.forEach(::record)
    }

    private fun record(sbn: StatusBarNotification) {
        val extras = sbn.notification.extras
        repository.record(
            key = sbn.key,
            packageName = sbn.packageName,
            title = extras.getCharSequence(Notification.EXTRA_TITLE)?.toString(),
            text = extras.getCharSequence(Notification.EXTRA_TEXT)?.toString(),
            subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT)?.toString(),
            postedAt = sbn.postTime,
        )
    }

    companion object {
        fun isEnabled(context: Context): Boolean {
            val manager = context.getSystemService(android.app.NotificationManager::class.java)
                ?: return false
            return manager.isNotificationListenerAccessGranted(
                ComponentName(context, AgentNotificationHistoryService::class.java),
            )
        }
    }
}
