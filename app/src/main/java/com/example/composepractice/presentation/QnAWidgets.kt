package com.example.composepractice.presentation

import android.R
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composepractice.ui.theme.colorBasic
import com.example.composepractice.ui.theme.colorPrimary
import com.example.composepractice.ui.theme.secondaryBlack100

@Composable
fun QnALists() {
    LazyColumn {
        items(15) {
            QnAItem()
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun QnAItem() {

    var isExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
            .background(color = colorBasic, shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier.clickable {
                isExpanded = !isExpanded
            },
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                GlideImage(
                    model = "https://cdn-icons-png.flaticon.com/512/219/219988.png",
                    contentDescription = "avatar",
                    modifier = Modifier
                        .padding(16.dp)
                        .size(36.dp, 36.dp)
                )

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "User Er Naam aaro onek onek onek boro ekta naam",
                        style = TextStyle(
                            fontWeight = FontWeight.W500,
                            fontSize = 13.sp,
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "10:45 PM 08-Aug-2023", style = TextStyle(
                            fontWeight = FontWeight.W400,
                            fontSize = 10.sp,
                            color = secondaryBlack100
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(.1f))

                Icon(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(10.dp),
                    painter = if (!isExpanded) painterResource(id = R.drawable.arrow_down_float) else painterResource(
                        id = R.drawable.arrow_up_float
                    ),
                    contentDescription = "",
                    tint = secondaryBlack100,
                )
            }

            Text(
                text = "Lorem ipsum dolor sit amet, conse ctetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Justify,
                softWrap = isExpanded,
                overflow = TextOverflow.Ellipsis,
            )

            // Replies are visible only when the question is expanded
            if (isExpanded) {
                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        LazyColumn(modifier = Modifier.height(500.dp)) {
                            items(5) {
                                ReplyItem()
                            }
                        }

                        // TODO: Add reply box
                        BasicTextField(
                            value = "Your reply...",
                            onValueChange = { /*TODO*/ },
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth()
                                .border(
                                    1.dp,
                                    color = colorPrimary,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(12.dp),
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ReplyItem() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Color.White, RoundedCornerShape(8.dp))
            .background(color = colorBasic, shape = RoundedCornerShape(8.dp))
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                GlideImage(
                    model = "https://cdn-icons-png.flaticon.com/512/219/219988.png",
                    contentDescription = "avatar",
                    modifier = Modifier
                        .padding(16.dp)
                        .size(36.dp, 36.dp)
                )

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "User Er Naam aaro onek boro boro boro ekta naam",
                        style = TextStyle(
                            fontWeight = FontWeight.W500,
                            fontSize = 13.sp,
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "10:45 PM 08-Aug-2023", style = TextStyle(
                            fontWeight = FontWeight.W400,
                            fontSize = 10.sp,
                            color = secondaryBlack100
                        )
                    )
                }

                Spacer(modifier = Modifier.weight(.1f))

                Icon(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(10.dp)
                        .clickable {

                        },
                    painter = painterResource(
                        id = R.drawable.ic_menu_view
                    ),
                    contentDescription = "",
                    tint = secondaryBlack100,
                )
            }

            Text(
                text = "Lorem ipsum dolor sit amet, conse ctetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                textAlign = TextAlign.Justify,
            )

        }
    }
}

@Composable
@Preview
fun QnAListsPreview() {
    QnALists()
}

@Composable
@DevicePreview
fun QnAItemPreview() {
    QnAItem()
}

@Composable
@Preview
fun ReplyItemPreview() {
    ReplyItem()
}

