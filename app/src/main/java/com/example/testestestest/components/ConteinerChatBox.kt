package com.example.testestestest.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testestestest.models.MessageData

@Composable
fun ConteinerChatBox(modifier: Modifier, listOfMessageData: List<MessageData>) {
    Spacer(Modifier.height(8.dp))
    listOfMessageData.forEach {
        ChatBox(message = it)
    }
}