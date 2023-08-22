package com.jk.designuijeetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                        CircularProgressBar(percentage = 0.8f, number = 100)
                    }

                }
            }
        }
    }
}

@Composable
fun CircularProgressBar(
    percentage:Float,
    number:Int,
    fontSize: TextUnit =28.sp,
    radius: Dp =50.dp,
    color:Color= Color.Green,
    strokeWidth:Dp =0.dp,
    animDuration:Int=1000,
    animDelay:Int=0
){
    var animatedPlayed by remember {
        mutableStateOf(false)
    }

    val currentPercentage= animateFloatAsState(
        targetValue = if (animatedPlayed) percentage else 0f ,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )

    LaunchedEffect(key1 = true, ){
        animatedPlayed=true
    }

    Box(
        modifier = Modifier.size(radius * 2f),
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.size(radius * 2f )){
            drawArc(
                color=color,
                -90f,
                360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(),cap= StrokeCap.Round)
            )
        }
        Text(text = (currentPercentage.value * number).toInt().toString(),
            color=Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold)
    }
}


