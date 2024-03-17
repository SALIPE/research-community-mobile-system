package com.example.research

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.research.ui.theme.ResearchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        name = "Felipe",
                        age = 22
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String, modifier: Modifier = Modifier, age: Int = 0) {

    val nameConcat: String = stringResource(R.string.happy_birthday).plus(name)
    val personAge: Int = calculateAge(age)
    val congratsMessage = "Congrats for your $personAge age birthday!"

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(5.dp)
    ) {
        Text(
            text = nameConcat,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
            )
        Text(
            text = congratsMessage,
            fontSize = 30.sp,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.from_android_team),
            fontSize = 20.sp,
            modifier = Modifier.align(alignment = Alignment.End)
        )
    }

}

@Composable
fun GreetingImage(name: String, age: Int, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)


    Box(modifier) {
        Image(painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop)
        GreetingText(
            name = "Felipe",
            age = 22,
            modifier = Modifier.fillMaxSize()
        )
    }
}

fun calculateAge(age: Int): Int {
    var initAge: Int = 0
    initAge += age
    return initAge
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ResearchTheme {
        GreetingImage(
            name = "Felipe",
            age = 22
        )
    }
}