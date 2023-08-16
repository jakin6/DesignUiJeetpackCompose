package com.jk.designuijeetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jk.designuijeetpackcompose.ui.theme.DesignUiJeetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DesignUiJeetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}


@Composable
fun Greeting() {
    Column(modifier = Modifier
        .background(Color.Cyan)
        .fillMaxHeight(0.5f)
        .fillMaxWidth()
//        .width(280.dp)
//        .height(200.dp)
        .padding(top = 15.dp, end = 15.dp)
        .border(5.dp,Color.Magenta)

      //  .width(23.dp)
 //       .requiredWidth(600.dp))
    ){
        //offset are like margins
        Text("Hello",
            modifier=Modifier.offset(0.dp,20.dp),
        )

//        Text("Hello",
//            modifier=Modifier.clickable {  })
//        )
        Spacer(modifier = Modifier.height(50.dp))
        Text("world")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignUiJeetpackComposeTheme {
        Greeting()
    }
}