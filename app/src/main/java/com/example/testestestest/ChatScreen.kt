package com.example.testestestest

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testestestest.components.ChatTextField
import com.example.testestestest.components.ConteinerChatBox
import com.example.testestestest.models.MessageData
import com.example.testestestest.utils.automationMessage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen() {

    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var listOfMessageData by remember { mutableStateOf(listOf<MessageData>()) }

    var scrollState = rememberScrollState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

            }
        }
    ) {

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Chat App") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        var expandedOptions by remember { mutableStateOf(false) }
                        IconButton(onClick = { expandedOptions = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "Options"
                            )
                        }
                        DropdownMenu(
                            expanded = expandedOptions,
                            onDismissRequest = { expandedOptions = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Limpiar chat") },
                                onClick = {
                                    expandedOptions = false
                                    listOfMessageData = listOf<MessageData>()
                                }
                            )
                        }
                    }
                )
            },
            bottomBar = {
                var valueTextField by remember { mutableStateOf("") }
                ChatTextField(
                    valueTextField = valueTextField,
                    onValueChange = { valueTextField = it },
                    onSendMessage = {
                        val newMessage = MessageData(
                            text = valueTextField,
                            isMine = true
                        )

                        listOfMessageData = listOfMessageData + newMessage
                        valueTextField = ""

                        val randomResponde = automationMessage()


                        scope.launch {
                            delay(100)
                            scrollState.animateScrollTo(scrollState.maxValue)

                            delay(600)
                            listOfMessageData = listOfMessageData + randomResponde

                            delay(100)
                            scrollState.animateScrollTo(scrollState.maxValue)
                        }
                    }
                )

            }
        ) { valuePadding ->
            Box(
                modifier = Modifier
                    .padding(valuePadding)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    ConteinerChatBox(modifier = Modifier.weight(1f), listOfMessageData)
                }
            }
        }

    }
}