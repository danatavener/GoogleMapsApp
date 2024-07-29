package com.example.googlemapsapp.ui.theme.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun MapsScreen(address: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp), 
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Text(text = "Enter address here:")
        SimpleTextField(address)
        Spacer(modifier = Modifier.fillMaxHeight(0.2f))
        Text(text = "Map placeholder")
    }
}

@Composable
fun SimpleTextField(startText: String?) {
    var text by remember { mutableStateOf(TextFieldValue("$startText")) }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )
}