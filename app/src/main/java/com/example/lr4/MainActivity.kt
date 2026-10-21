package com.example.lr4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lr4.ui.theme.Lr4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lr4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->


                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SumN(modifier: Modifier = Modifier){
    val nInput = remember { mutableStateOf("") }
    val res = remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = nInput.value,
            onValueChange = {nInput. value = it},
            label = {Text("Введите символ")}
        )

        Button(onClick = {
            val n = nInput.value.toIntOrNull()
            if (n == null) {
                res.value = "Введите символ"
            } else {
                res.value = summ(n).toString()
            }
        }) {
            Text("Проверить")
        }
        Text(text = res.value)
    }
}

fun factorial(n: Int): Int {
    if (n!=1) {
        return n * factorial(n-1)
    } else return 1
}

fun summ(n: Int): Float {
    var s: Float = 0.0f
    for (i in 1..n) {
        s += 1.0f/(factorial(i))
    }
    return s
}