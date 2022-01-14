package com.smarttoolfactory.composespeechbubble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.composespeechbubble.ui.theme.ComposeSpeechBubbleTheme
import com.smarttoolfactory.speechbubble.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSpeechBubbleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(8.dp)) {

                        val bubbleState = rememberBubbleState().apply {
                            arrowAlignment = LEFT_TOP
//                            arrowWidth = 20f
//                            arrowHeight = 15f
//                            arrowOffsetY = 3f
//                            arrowShape = ArrowShape.TRIANGLE_ISOSCELES
                        }



                        BubbleLayout(bubbleState = bubbleState) {
                            Text(
                                "Hello World",
                                fontSize = 16.sp,
                                modifier = Modifier
//                                    .background(Color(0x33000000))
                                    .padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MyComposable() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        var totalSize = Size.Zero

        val modifier = Modifier
            .layout { measurable, constraints ->

                val placeable = measurable.measure(constraints)
                totalSize = Size(placeable.width + 50f, placeable.height.toFloat())

                println("!!!LAYOUT placeable: $placeable")

                layout(placeable.width + 50, placeable.height) {
                    println("LAYOUT IN")
                    placeable.place(0, 0)
                }

            }
            .drawBehind {
                println("✏️ DRAWING size: $size")
                drawRect(Color.Red, size = totalSize, style = Stroke(2f))
                drawRect(Color.Blue, size = size, style = Stroke(2f))
            }
            .onSizeChanged {
                println("🚀 onSizeChanged size: $it")
            }

        Column(modifier = modifier) {
            println("🔥COMPOSITION")

        }

    }
}