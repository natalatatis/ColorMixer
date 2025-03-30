package com.example.tasklistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorMixerScreen()
        }
    }
}

@Composable
fun ColorMixerScreen() {
    //state variables for red, green and blue
    //the value of each color is between 0f and 1f
    var red by remember { mutableStateOf(0f)}
    var green by remember { mutableStateOf(0f)}
    var blue by remember { mutableStateOf(0f)}

    //current color to be displayed is a combination of all three rgb values
    val currentColor = Color(red, green, blue)

    Column(
        modifier= Modifier
            .fillMaxSize() //take up all available space
            .padding(16.dp), //padding around the whole content
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //title on the screen
        Text(text="Color Mixer", style= MaterialTheme.typography.headlineMedium)

        //red
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Red: ${"%.2f".format(red)}",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ))
        Slider(
            value=red, //current value
            onValueChange = {red=it}, //update value when the slider moves
            valueRange=0f..1f, //the range for the value is from 0.0 (no red) to 1.0 (full red)
            modifier=Modifier.fillMaxWidth() //make the slider occupy the full width
        )
        //green
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Green: ${"%.2f".format(green)}", style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ))
        Slider(
            value=green,
            onValueChange = {green=it}, //update value when the slider moves
            valueRange=0f..1f,//the range for the value is from 0.0 (no green) to 1.0 (full green)
            modifier=Modifier.fillMaxWidth()//make the slider occupy the full width
        )
        //blue
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Blue: ${"%.2f".format(blue)}", style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        ))
        Slider(
            value=blue,
            onValueChange = {blue=it},//update value when the slider moves
            valueRange=0f..1f, //the range for the value is from 0.0 (no blue) to 1.0 (full blue)
            modifier=Modifier.fillMaxWidth()//make the slider occupy the full width
        )
        Spacer(modifier = Modifier.height(16.dp))

        //box that shows the color (the resulting mixture of values)
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(currentColor)
        )
        Spacer(modifier = Modifier.height(16.dp))
        //displays the hex of the color
        Text("Resulting Color: #${currentColor.toArgb().toString(16).uppercase()}")
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   ColorMixerScreen()
}
