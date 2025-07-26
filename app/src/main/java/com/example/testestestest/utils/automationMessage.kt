package com.example.testestestest.utils

import com.example.testestestest.models.MessageData

val listOfMessages = listOf(
    "Hola",
    "Como estas?",
    "Kiki hermosa",
    "Te amo uwu",
    "HERMOÑAAAA"
)

fun automationMessage(): MessageData {
    val randomMessage = listOfMessages.random()

    val newRandomMessage = MessageData(text = randomMessage, isMine = false)

    return newRandomMessage
}