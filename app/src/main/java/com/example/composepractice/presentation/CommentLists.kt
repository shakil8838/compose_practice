package com.example.composepractice.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.R
import com.example.composepractice.ui.theme.fontSize12
import com.example.composepractice.ui.theme.fontSize14
import com.example.composepractice.ui.theme.fontWeight700

@Composable
fun CommentLists(listOfComments: List<Any> = listOf()) {
    LazyColumn(content = {
        items(listOfComments.size) { index ->
            CommentItem(
                userName = "Al Asma Ul Husna", // TODO: Replace with actual user name
                comment = "আমি একটি মেডিকেল স্টুডেন্ট। আমি একটি মেডিকেল স্টুডেন্ট। আমি একটি মেডিকেল স্টুডেন্ট। আমি একটি মেডিকেল স্টুডেন্ট। আমি একটি মেডিকেল স্টুডেন্ট।" // TODO: Replace with actual comment
            )
        }
    })
}

@Composable
fun CommentItem(userName: String, comment: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_icon_user_avatar),
                contentDescription = "",
                modifier = Modifier
                    .padding(4.dp)
                    .size(36.dp)
            )
            Column(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(
                    text = userName,
                    fontSize = fontSize14,
                    fontWeight = fontWeight700,
                )

                Text(
                    text = comment,
                    fontSize = fontSize12,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(end = 4.dp, top = 4.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewCommentLists() {
    CommentLists(
        listOfComments = listOf(
            "আমি একটি মেডিকেল স্টুডেন্ট। আমি একটি মেডিকেল স্টুডেন্ট। আমি একটি মেডিকেল স্টুডেন্ট।",
            "আমি একটি মেডিকেল স্টুডেন্ট।",
            "আমি একটি মেডিকেল স্টুডেন্ট।",
            "আমি একটি মেডিকেল স্টুডেন্ট।",
            "আমি একটি মেডিকেল স্টুডেন্ট।",
            "আমি একটি মেডিকেল স্টুডেন্ট।"
        )
    )
}

@Composable
@Preview
fun PreviewCommentItem() {
    CommentItem(
        userName = "মোঃ আব্দুল কাদের",
        comment = "আমি একটি মেডিকেল স্টুডেন্ট। আমি একটি মেডিকেল স্টুডেন্ট। আমি একটি মেডিকেল স্টুডেন্ট। আমি একটি মেডিকেল স্টুডেন্ট।"
    )
}