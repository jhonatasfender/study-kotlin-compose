package org.poc.ui.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @link https://developer.android.com/develop/ui/compose/mental-model?hl=pt-br
 */
@Composable
fun ComposeGuidePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Como trabalhar com o Compose",
            style = MaterialTheme.typography.headlineMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val names = listOf("John", "Jane", "Jim", "Jill")
            for (name in names) {
                Text("Hello $name")
            }
        }

        Box {
            var clicks by remember { mutableStateOf(0) }
            
            Button(
                onClick = { clicks++ },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("I've been clicked $clicks times")
            }
        }

        Column {
            Text("Header", style = MaterialTheme.typography.bodyLarge)
            HorizontalDivider()

            LazyColumn {
                items(List(3) { it }) { index ->
                    Text("Item #$index")
                }
            }
        }
    }
}