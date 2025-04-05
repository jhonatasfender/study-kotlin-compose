package org.poc.ui.pages

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarDuration
import kotlinx.coroutines.launch
import kotlinx.coroutines.GlobalScope

@Composable
fun SideEffectsPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Side Effects",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "This page demonstrates how to work with side effects in Compose Multiplatform. " +
                "Side effects are operations that happen outside of the normal flow of a composable function, " +
                "such as launching animations, working with lifecycle events, or making network requests.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Exemplo de LaunchedEffect com Animação",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        var pulseRateMs by remember { mutableStateOf(3000L) }
        val alpha = remember { Animatable(1f) }

        Button(
            onClick = { 
                pulseRateMs = if (pulseRateMs == 3000L) 1000L else 3000L 
            },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("Alterar velocidade: $pulseRateMs ms")
        }

        Text(
            text = "Este Texto está pulsando!",
            modifier = Modifier.graphicsLayer(alpha = alpha.value),
            style = MaterialTheme.typography.bodyLarge
        )

        LaunchedEffect(pulseRateMs) {
            while (isActive) {
                delay(pulseRateMs)
                alpha.animateTo(0f)
                alpha.animateTo(1f)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Exemplo de rememberCoroutineScope",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        val scope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }

        Text(
            text = "Exemplo de rememberCoroutineScope com Snackbar",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Button(
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = "Este é um exemplo de Snackbar!",
                        duration = SnackbarDuration.Short
                    )
                }
            }
        ) {
            Text("Mostrar Snackbar")
        }

        SnackbarHost(hostState = snackbarHostState)

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Exemplo de DisposableEffect com rememberUpdateState",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        var isVisible by remember { mutableStateOf(true) }

        Button(
            onClick = { isVisible = !isVisible },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(if (isVisible) "Esconder o Componente" else "Mostrar o Componente")
        }

        if(isVisible) {
            ComponenteComMonitoramento()
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun ComponenteComMonitoramento() {
    val onStart = {
        println("ComponenteComMonitoramento: Componente Iniciado")
    }

    val onStop = {
        println("ComponenteComMonitoramento: Componente parado!")
    }

    val currentOnStart by rememberUpdatedState(onStart)
    val currentOnStop by rememberUpdatedState(onStop)

    var tempoVisivel by remember { mutableStateOf(0L) }

    DisposableEffect(Unit) {
        val startTime = System.currentTimeMillis()

        currentOnStart()

        val job = GlobalScope.launch {
            while (true) {
                delay(1000)
                tempoVisivel = (System.currentTimeMillis() - startTime) / 1000
            }
        }

        onDispose {
            currentOnStop()
            job.cancel()
            println("ComponenteComMonitoramento: Componente ficou visível por $tempoVisivel segundos")
        }
    }

    Column {
        Text(
            text = "Este componente está visível há $tempoVisivel segundos",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = "Observe o console para ver as mensagens de início/parada",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}