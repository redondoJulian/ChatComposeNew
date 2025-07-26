package com.example.testestestest.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testestestest.models.MessageData

@Composable
fun ChatBox(
    message: MessageData
) {
    Box( //Contenedor
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = if (message.isMine) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Box( //Limitador
            modifier = Modifier.fillMaxWidth(fraction = 0.8f),
            contentAlignment = if (message.isMine) Alignment.CenterEnd else Alignment.CenterStart
        ) {
            Card(
                modifier = Modifier.padding(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (message.isMine) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Text(text = message.text, modifier = Modifier.padding(16.dp))
            }
        }
    }
}