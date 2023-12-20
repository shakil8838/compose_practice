package com.example.composepractice.presentation

import android.util.Log
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ColorBrandSecondary
import com.example.composepractice.ui.theme.colorPrimary
import com.example.composepractice.ui.theme.colorPrimary100

private const val TAG = "AuthenticationChat"

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
fun AuthOption(authOption: (Int) -> Unit) {
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

    var pageState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        // provide pageCount
        3
    }

    var pageGreetings by remember {
        mutableStateOf("ধন্যবাদ, নিবন্ধনের প্রথম ধাপ সম্পন্ন হয়েছে, দ্বিতীয় ধাপে তোমার প্রোফাইল আপডেট করতে কিছু তথ্য প্রয়োজন")
    }

    Column(
        modifier = Modifier
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 32.dp)
            .drawBehind { drawChatBubble() }
            .padding(8.dp),
    ) {

        Text(text = pageGreetings)

        PageDivider(3)

        HorizontalPager(
//            pageCount = 3,
            state = pageState,
        ) { index ->

            currentPage = index

            when (index) {
                0 -> {
//                    NameField {
//                        Log.e(TAG, "RegistrationForm: $it")
//                        pageGreetings = "ধন্যবাদ, $it তুমি কোন ক্লাসে পড়ো সেটি সিলেক্ট কর।"
//                    }
                    NameField(name ={
                        Log.e(TAG, "RegistrationForm: $it")
                        pageGreetings = "ধন্যবাদ, $it তুমি কোন ক্লাসে পড়ো সেটি সিলেক্ট কর।"
                    }) {
//                        scope.launch {
//                            pageState.animateScrollToPage(
//                                pageState.currentPage + 1
//                            )
//                        }
                    }
                }

                1 -> {
                    ClassSelection()
                }

                2 -> {
                    InfoConfirmation()
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
private fun NameField(name: (String) -> Unit, clicked: () -> Unit) {
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
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                ) {
                    if (userName.isEmpty()) {
                        Text(
                            text = "Your Full Name...",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                    innerTextField()
                }
            }
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Button(
                onClick = {
                    if (userName.isNotEmpty()) {
                        name(userName)
                    }
                    clicked()
                },
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
fun ClassSelection() {

    val classList =
        arrayOf("১ম", "২য়", "৩য়", "৪র্থ", "৫ম", "৬ষ্ট", "৭ম", "৮ম", "৯ম", "১০ম", "১১শ", "১২শ")

    var selectedClass by remember {
        mutableStateOf(0)
    }

    var selectedGroup by remember {
        mutableStateOf("Scince")
    }
    Column(
        modifier = Modifier
//            .padding(16.dp)
//            .drawBehind { drawChatBubble() }
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(5), content = {
            items(classList.size) { index ->
                Box(
                    modifier = Modifier
                        .width(44.dp)
                        .height(44.dp)
                        .padding(4.dp)
                        .background(
                            color = if (selectedClass == index) colorPrimary else Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable {
                            selectedClass = index
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = classList[index],
                        style = TextStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.W700,
                            fontSize = 13.sp
                        )
                    )
                }
            }
        })

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Group:", style = TextStyle(fontWeight = FontWeight.Bold))
            RadioButton(
                selected = selectedGroup == "Scince",
                onClick = { selectedGroup = "Scince" })
            Text(text = "Scince")
            RadioButton(
                selected = selectedGroup == "Arts",
                onClick = { selectedGroup = "Arts" },

                )
            Text(text = "Arts")
            RadioButton(
                selected = selectedGroup == "Commerce",
                onClick = { selectedGroup = "Commerce" })
            Text(text = "Commerce")
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = {

                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 8.dp)
                    .padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorBrandSecondary,
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Back", style = TextStyle(color = colorPrimary))
            }

            Button(
                onClick = {

                },
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 8.dp)
                    .padding(start = 8.dp),
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
fun InfoConfirmation() {

    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
//        .padding(16.dp)
//        .drawBehind { drawChatBubble() }
//        .padding(16.dp)
    ) {

        Row {
            Text(
                text = "নামঃ ",
                style = TextStyle(
                    fontWeight = FontWeight.W500,
                    fontSize = 13.sp,
                    color = Color.Black
                )
            )
            Text(
                text = "UserName",
                style = TextStyle(
                    fontWeight = FontWeight.W500,
                    fontSize = 13.sp,
                    color = colorPrimary
                )
            )
        }

        Row {
            Text(
                text = "শ্রেণীঃ ",
                style = TextStyle(
                    fontWeight = FontWeight.W500,
                    fontSize = 13.sp,
                    color = Color.Black
                )
            )
            Text(
                text = "UserName",
                style = TextStyle(
                    fontWeight = FontWeight.W500,
                    fontSize = 13.sp,
                    color = colorPrimary
                )
            )
        }

        Row {
            Text(
                text = "বিভাগঃ ",
                style = TextStyle(
                    fontWeight = FontWeight.W500,
                    fontSize = 13.sp,
                    color = Color.Black
                )
            )
            Text(
                text = "UserName",
                style = TextStyle(
                    fontWeight = FontWeight.W500,
                    fontSize = 13.sp,
                    color = colorPrimary
                )
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(8.dp)
                .clickable {

                }

        ) {
            Text(text = "হ্যাঁ, তথ্য সঠিক  আছে।", style = TextStyle(color = colorPrimary))
        }

        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .padding(8.dp)
                .clickable {

                }

        ) {
            Text(text = "না, তথ্য পরিবর্তন করতে চাই", style = TextStyle(color = Color.Red))
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
//    NameField(name = {
//        println(it)
//    })
}

//@DevicePreview
@Composable
@Preview
fun ClassSelectionPreview() {
    ClassSelection()
}

@Composable
@Preview
fun InfoConfirmationPreview() {
    InfoConfirmation()
}