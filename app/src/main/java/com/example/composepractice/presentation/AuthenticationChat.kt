package com.example.composepractice.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.theme.ColorBrandSecondary
import com.example.composepractice.ui.theme.colorPrimary
import com.example.composepractice.ui.theme.colorPrimary100

private val TriangleShape = GenericShape { size, _ ->
    moveTo(0f, 0f)
    lineTo(0f, 0f)
    lineTo(size.width, size.height)
    lineTo(size.width, size.height)
}

fun DrawScope.drawChatBubble(isSender: Boolean = true) {

    if (isSender) {
        drawLine(
            color = colorPrimary100,
            start = Offset(10f, 5f),
            end = Offset(-10f, 30f),
            strokeWidth = 4.dp.toPx(),

            )
        drawLine(
            color = colorPrimary100,
            start = Offset(-15f, 30f),
            end = Offset(10f, 30f),
            strokeWidth = 2.dp.toPx()
        )
    } else {
        drawLine(
            color = colorPrimary100,
            start = Offset(size.width + 8f, 0f),
            end = Offset(size.width - 8, 35f),
            strokeWidth = 4.dp.toPx(),
        )
        drawLine(
            color = colorPrimary100,
            start = Offset(size.width + 12, 0f),
            end = Offset(size.width - 10, 5f),
            strokeWidth = 3.dp.toPx()
        )
    }
    drawRoundRect(
        color = colorPrimary100,
        topLeft = Offset.Zero,
        size = size,
        cornerRadius = CornerRadius(
            4.dp.toPx(), 4.dp.toPx()
        )
    )
}

@Composable
fun ChatSimpleText(chatText: String) {

    Text(
        text = chatText,
        modifier = Modifier
            .padding(8.dp)
            .drawBehind { drawChatBubble() }
            .padding(8.dp),
    )
}

@Composable
fun AuthOption(authOption: (option: Int) -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 32.dp)
            .drawBehind { drawChatBubble() }
            .padding(8.dp),
    ) {
        Text(
            text = "আমি উৎকর্ষ তোমার পার্সোনাল এসিস্টেন্ট। উৎকর্ষে তোমার কি কোন একাউন্ট রয়েছে?"
        )

        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(8.dp)
                .clickable {
                    authOption(0)
                }

        ) {
            Text(text = "হ্যাঁ, আমার একাউন্ট  আছে।", style = TextStyle(color = colorPrimary))
        }

        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(8.dp)
                .clickable {
                    authOption(1)
                }

        ) {
            Text(text = "না, আমার একাউন্ট নেই।", style = TextStyle(color = Color.Red))
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegistrationForm() {

    val pageState = rememberPagerState()

    Column(
        modifier = Modifier
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 32.dp)
            .drawBehind { drawChatBubble() }
            .padding(8.dp),
    ) {
        Text(text = "ধন্যবাদ, নিবন্ধনের প্রথম ধাপ সম্পন্ন হয়েছে, দ্বিতীয় ধাপে তোমার প্রোফাইল আপডেট করতে কিছু তথ্য প্রয়োজন")

        PageDivider()

        HorizontalPager(
            pageCount = 2,
            state = pageState,
        ) { index ->

            currentPage = index

            when (index) {
                0 -> {
                    NameField()
                }

                1 -> {

                }
            }
        }
    }
}

var currentPage by mutableStateOf(0)

@Composable
private fun PageDivider(pageCount: Int = 2) {
    Row(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        for (i in 0 until pageCount) {
            Divider(
                Modifier
                    .height(2.dp)
                    .width((64 / (pageCount * .2)).dp),
                color = if (currentPage == i) colorPrimary else ColorBrandSecondary
            )
        }
    }
}

@Composable
private fun NameField() {
    var userName by remember {
        mutableStateOf("")
    }
    Column {
        BasicTextField(
            value = userName,
            onValueChange = { newText -> userName = newText },
            singleLine = true,
            textStyle = TextStyle(
                // TODO: Implement text style
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    // TODO: Handle send action
                }
            ),
            decorationBox = {
                if (userName.isEmpty()) {
                    Text(
                        text = "Your Full Name...",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = androidx.compose.ui.Alignment.CenterEnd
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorPrimary,
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Next")
            }

        }
    }
}

@Composable
@Preview
fun ChatSimpleTextPreview() {
    ChatSimpleText("শুভ সকাল!")
}

@Composable
@Preview
fun AuthOptionPreview() {
    AuthOption(authOption = {
        println(it)
    })
}

@Composable
@Preview
fun RegistrationFormPreview() {
    RegistrationForm()
}

@Composable
@Preview
fun NameFieldPreview() {
    NameField()
}