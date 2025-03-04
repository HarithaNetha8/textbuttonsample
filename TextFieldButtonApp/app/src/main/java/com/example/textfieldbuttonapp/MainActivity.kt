package com.example.textfieldbuttonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.textfieldbuttonapp.ui.theme.TextFieldButtonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextFieldButtonAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserInputScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UserInputScreen(modifier: Modifier = Modifier) {
    var userInput by remember { mutableStateOf("") }
    var displayText by remember { mutableStateOf("Output will appear here") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Enter text") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { displayText = "You entered: $userInput" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Click Me")
        }

        Text(
            text = displayText,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserInputScreenPreview() {
    TextFieldButtonAppTheme {
        UserInputScreen()
    }
}
