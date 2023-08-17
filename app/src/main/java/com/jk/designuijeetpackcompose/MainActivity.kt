package com.jk.designuijeetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
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
     val constraints= ConstraintSet{
         val greenBox=createRefFor("grrenBox")
         val redBox=createRefFor("redBox")
         val guideline=createGuidelineFromTop(0.5f)

         constrain(greenBox){
             top.linkTo(guideline)
             start.linkTo(parent.start)
             width= Dimension.value(100.dp)
             height=Dimension.value(100.dp)
         }

         constrain(redBox){
             top.linkTo(parent.top)
             start.linkTo(greenBox.end)
             end.linkTo(parent.end)
//             width=Dimension.value(100.dp)
             width=Dimension.value(100.dp)
             height= Dimension.value(100.dp)
         }
         createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Packed)
     }
         ConstraintLayout(constraintSet =constraints , modifier = Modifier.fillMaxSize()) {
             Box(modifier = Modifier
                 .background(Color.Green)
                 .layoutId("greenBox"))
             Box(modifier = Modifier
                 .background(Color.Red)
                 .layoutId("redBox"))
         }
         
     }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesignUiJeetpackComposeTheme {
        Greeting()
    }
}