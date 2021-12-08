package com.nana.composetest.ui.theme

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nana.composetest.ui.theme.ui.theme.ComposeTestTheme

class MainActivityTest : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background, ) {
                    Greeting2("Android")
                }
            }
            Text(text = "NaNa")

        }

    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")

}

@Preview(showBackground = true, name = "Android")
@Composable
fun DefaultPreview2() {
    ComposeTestTheme {
        Greeting2("Android")
    }

}


@Preview(showBackground = true, name = "NaNa")
@Composable
fun DefaultPreviewTest() {
    ComposeTestTheme {
        Greeting2("Nana")
    }
}

