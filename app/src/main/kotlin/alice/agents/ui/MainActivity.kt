package alice.agents.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import alice.agents.ui.app.AgentAppRoot
import alice.agents.ui.app.AgentAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgentAppTheme {
                AgentAppRoot()
            }
        }
    }
}
