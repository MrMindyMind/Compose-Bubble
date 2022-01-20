package com.smarttoolfactory.composespeechbubble

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smarttoolfactory.speechbubble.*

@Composable
fun DemoDynamicSize() {

    var message by remember { mutableStateOf("Very Long Message") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp, horizontal = 20.dp)
            .background(Color(0xffFBE9E7))
    ) {

        LazyColumn(
            modifier = Modifier.weight(1f),
            content = {

                item {
                    RightArrowBubbleLayoutSamples(message)
                }

//                item {
//                    LeftArrowBubbleLayoutWithShapeSamples(message)
//                }
            })

        OutlinedTextField(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            value = message,
            label = { Text("Main") },
            placeholder = { Text("Set text to change main width") },
            onValueChange = { newValue: String ->
                message = newValue
            }
        )

    }
}

@Composable
private fun RightArrowBubbleLayoutSamples(message: String) {

//    Box(
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth(),
//        contentAlignment = Alignment.Center
//    ) {
//        BubbleLayout(
//            bubbleState = rememberBubbleState(
//                alignment = ArrowAlignment.NONE,
//                backgroundColor = DateColor,
//                cornerRadius = 5.dp,
//                shadow = BubbleShadow(
//                    elevation = 1.dp
//                ),
//                padding = Padding(8.dp)
//            )
//
//        ) {
//            Text(
//                "BubbleLayout",
//                fontSize = 16.sp,
//            )
//        }
//    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End
    ) {

        BubbleLayout(
            bubbleState = rememberBubbleState(
                backgroundColor = SentMessageColor,
                arrowWidth = 20.dp,
                arrowHeight = 20.dp,
                alignment = ArrowAlignment.RIGHT_TOP,
                cornerRadius = 8.dp,
                shadow = BubbleShadow(elevation = 1.dp),
                padding = Padding(8.dp)
            )
        ) { Text(text = message) }

        BubbleColumn(
            bubbleState = rememberBubbleState(
                backgroundColor = SentMessageColor,
                arrowWidth = 20.dp,
                arrowHeight = 20.dp,
                alignment = ArrowAlignment.RIGHT_TOP,
                cornerRadius = 8.dp,
                shadow = BubbleShadow(elevation = 1.dp),
                padding = Padding(8.dp)
            )
        ) { Text(text = message) }

//        Spacer(modifier = Modifier.height(4.dp))
//
//        BubbleLayout(
//            bubbleState = rememberBubbleState(
//                backgroundColor = SentMessageColor,
//                arrowWidth = 20.dp,
//                arrowHeight = 20.dp,
//                alignment = ArrowAlignment.RIGHT_TOP,
//                arrowOffsetY = 6.dp,
//                cornerRadius = 8.dp,
//                shadow = BubbleShadow(elevation = 1.dp),
//                padding = Padding(8.dp)
//            )
//        ) { Text(text = message) }
//
//        Spacer(modifier = Modifier.height(4.dp))
//
//        BubbleLayout(
//            bubbleState = rememberBubbleState(
//                backgroundColor = SentMessageColor,
//                alignment = ArrowAlignment.RIGHT_CENTER,
//                arrowWidth = 20.dp,
//                arrowHeight = 20.dp,
//                arrowShape = ArrowShape.TRIANGLE_ISOSCELES,
//                cornerRadius = 8.dp,
//                shadow = BubbleShadow(elevation = 1.dp),
//                padding = Padding(8.dp)
//            )
//        ) { Text(text = message) }
//
//        Spacer(modifier = Modifier.height(4.dp))
//
//        BubbleLayout(
//            bubbleState = rememberBubbleState(
//                backgroundColor = SentMessageColor,
//                arrowWidth = 20.dp,
//                arrowHeight = 20.dp,
//                alignment = ArrowAlignment.RIGHT_BOTTOM,
//                drawArrow = false,
//                cornerRadius = 12.dp,
//                shadow = BubbleShadow(elevation = 1.dp),
//                padding = Padding(8.dp)
//            )
//        ) {
//            Text(text = message)
//        }
    }
}


@Composable
private fun LeftArrowBubbleLayoutWithShapeSamples(message: String) {

    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        BubbleLayoutWithShape(
            bubbleState = rememberBubbleState(
                alignment = ArrowAlignment.NONE,
                backgroundColor = DateColor,
                cornerRadius = 5.dp,
                shadow = BubbleShadow(
                    elevation = 1.dp
                ),
                padding = Padding(8.dp)
            )

        ) {
            Text(
                "BubbleLayoutWithShape",
                fontSize = 16.sp,
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        BubbleColumn(
            bubbleState = rememberBubbleState(
                backgroundColor = DefaultBubbleColor,
                alignment = ArrowAlignment.LEFT_TOP,
                arrowWidth = 20.dp,
                arrowHeight = 20.dp,
                cornerRadius = 8.dp,
                shadow = BubbleShadow(elevation = 1.dp),
                padding = Padding(8.dp)
            )
        ) { Text(text = message) }

        Spacer(modifier = Modifier.height(4.dp))

        BubbleColumn(
            bubbleState = rememberBubbleState(
                backgroundColor = DefaultBubbleColor,
                alignment = ArrowAlignment.LEFT_TOP,
                arrowWidth = 20.dp,
                arrowHeight = 20.dp,
                arrowOffsetY = 6.dp,
                cornerRadius = 8.dp,
                shadow = BubbleShadow(elevation = 1.dp),
                padding = Padding(8.dp)
            )
        ) { Text(text = message) }

        Spacer(modifier = Modifier.height(4.dp))

        BubbleColumn(
            bubbleState = rememberBubbleState(
                backgroundColor = DefaultBubbleColor,
                alignment = ArrowAlignment.LEFT_CENTER,
                arrowShape = ArrowShape.TRIANGLE_ISOSCELES,
                arrowWidth = 20.dp,
                arrowHeight = 20.dp,
                cornerRadius = 8.dp,
                shadow = BubbleShadow(elevation = 1.dp),
                padding = Padding(8.dp)
            )
        ) { Text(text = message) }

        Spacer(modifier = Modifier.height(4.dp))

        BubbleColumn(
            bubbleState = rememberBubbleState(
                backgroundColor = DefaultBubbleColor,
                alignment = ArrowAlignment.LEFT_BOTTOM,
                arrowWidth = 20.dp,
                arrowHeight = 20.dp,
                drawArrow = false,
                cornerRadius = 12.dp,
                shadow = BubbleShadow(elevation = 1.dp),
                padding = Padding(8.dp)
            )
        ) {
            Text(text = message)
        }
    }
}