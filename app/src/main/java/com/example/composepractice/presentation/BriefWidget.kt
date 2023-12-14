package com.example.composepractice.presentation

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.R

@Composable
fun BriefCard(
    title: String,
    courseTitle: String,
    description: String,
    duration: String = "0:00",
    subjectListList: List<Any>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFFFFF))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(8.dp, 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon_play_btn),
                        contentDescription = "",
                    )
                    Column(
                        modifier = Modifier
                            .offset(16.dp),
                    ) {
                        Text(text = title)
                        Text(text = duration)
                    }
                }
            }
            Column(
                modifier = Modifier
                    .offset(y = 16.dp)
                    .background(Color(0xFFFFFFFF))
            ) {
                Text(
                    text = courseTitle,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontWeight = FontWeight(700))
                )
                Text(
                    text = description,
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontWeight = FontWeight(400))
                )
                Text(
                    text = "বিষয় সমূহ",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(fontWeight = FontWeight(700))
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.padding(16.dp),
                    content = {
                        items(subjectListList.size) { index ->
                            SingleGridElement(title = subjectListList[index].toString())
//                            RoundedRectangleWithImageAndText()
                        }
                    })
                Spacer(modifier = Modifier.padding(16.dp))
            }
        }
    }

}

@Composable
fun SingleGridElement(
    title: String,
    icon: Painter = painterResource(id = R.drawable.ic_icon_play_btn),
) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = icon,
                contentDescription = "",
            )
            Column(
                modifier = Modifier
                    .offset(16.dp),
            ) {
                Text(text = title)
            }
        }
    }
}

@Preview
@Composable
fun PreviewBriefCard() {
    BriefCard(
        courseTitle = "পদার্থবিজ্ঞান ১ম পত্র Module 1, রসায়ন ১ম পত্র Module 1, উচ্চতর গণিত ১ম পত্র Module 1, জীববিজ্ঞান।",
        title = "Introduction",
        description = "এইচএসসির সিলেবাস এসএসসির তুলনায় দ্বিগুণেরও বেশি, কিন্তু সেই তুলনায় সময় কম। সায়েন্সের সাবজেক্টগুলির জন্যে প্রথম থেকে ঠিকভাবে প্রস্তুতি না নিলে তোমাকে বোর্ড পরীক্ষা এবং অ্যাডমিশনের সময় ভুগতে হবে। উৎকর্ষ তোমাকে এইচএসসির প্রথম বর্ষ থেকে অ্যাডমিশন পর্যন্ত এমনভাবে গাইড করবে, যেন তোমার Preparation হয় Smart! ফিজিক্স, কেমিস্ট্রি, ম্যাথ আর বায়োলজি- চারটি সাবজেক্টের Module 1 একত্রে পাবে এই বান্ডেল প্যাকেজে, আকর্ষণীয় ডিসকাউন্টে। Show More",
        subjectListList = listOf("Subject 1", "Subject 2", "Subject 3")
    )
}

@Preview
@Composable
fun PreviewSingleGridElement() {
    SingleGridElement(
        title = "বাংলা ১ম পত্র",
    )
}

@Composable
fun RoundedRectangleWithImageAndText() {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            // Image
            Image(
                painter = painterResource(id = R.drawable.ic_icon_play_btn),
                contentDescription = "Image",
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = "Your Text",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoundedRectangleWithImageAndTextPreview() {
    RoundedRectangleWithImageAndText()
}