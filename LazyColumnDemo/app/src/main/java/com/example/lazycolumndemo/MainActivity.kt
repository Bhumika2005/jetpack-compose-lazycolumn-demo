package com.example.lazycolumndemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.lazycolumndemo.ui.theme.LazyColumnDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //Comment & uncomment fun to show result Column and LazyColumn as per requirement.
                    // ColumnScrollPropertyDemo()
                    LazyColumnDemo()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnScrollPropertyDemo() {
    val modifier = Modifier.padding(15.dp)
    val inputValue = remember { mutableStateOf(TextFieldValue()) }
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        repeat(10) {
            Text(
                text = "Index $it",
                modifier = modifier
            )
        }
        TextField(
            // below line is used to get
            // value of text field,
            value = inputValue.value,

            // below line is used to get value in text field
            // on value change in text field.
            onValueChange = {
                inputValue.value = it
            },
            label = { Text("User Name") }
        )
        repeat(10) {
            Text(
                text = "Index ${it+10}",
                modifier = modifier
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyColumnDemo() {
    val inputValue = remember { mutableStateOf(TextFieldValue()) }
    val modifier = Modifier.padding(15.dp)
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(10) { item ->
            Text(
                text = "Hello Android",
                modifier = modifier
            )
        }
        item {
            TextField(
                // below line is used to get
                // value of text field,
                value = inputValue.value,

                // below line is used to get value in text field
                // on value change in text field.
                onValueChange = {
                    inputValue.value = it
                },
                label = { Text("User Name") }
            )
        }
        items(10) { item ->
            Text(
                text = "Hello Kotlin",
                modifier = modifier
            )
        }
    }
}
