package com.example.composepractice.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composepractice.R
import com.example.composepractice.ui.theme.secondaryBlack100

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ProfileBody() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            GlideImage(
                model = "https://cdn-icons-png.flaticon.com/512/219/219988.png",
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = CircleShape)
            )

            Text(
                text = "Name",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    textAlign = TextAlign.Center
                )
            )

            Text(
                text = "Class SSC | Science",
                style = TextStyle(
                    color = secondaryBlack100,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = "+8801234567890",
                style = TextStyle(
                    color = secondaryBlack100,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(top = 4.dp)
            )

            Row(
                modifier = Modifier.padding(top = 8.dp, end = 8.dp)
            ) {
                OutlinedTextField(
                    value = "Science",
                    onValueChange = {},
                    label = { Text(text = "Section") },
                    enabled = false,
                    readOnly = true,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )

                OutlinedTextField(
                    value = "Science",
                    onValueChange = {},
                    label = { Text(text = "Board") },
                    enabled = false,
                    readOnly = true,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }

            Row(
                modifier = Modifier.padding(top = 8.dp, end = 8.dp)
            ) {
                OutlinedTextField(
                    value = "Science",
                    onValueChange = {},
                    label = { Text(text = "Session") },
                    enabled = false,
                    readOnly = true,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )

                OutlinedTextField(
                    value = "Science",
                    onValueChange = {},
                    label = { Text(text = "Exam Year") },
                    enabled = false,
                    readOnly = true,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }

            Row(
                modifier = Modifier.padding(top = 8.dp, end = 8.dp)
            ) {
                OutlinedTextField(
                    value = "Science",
                    onValueChange = {},
                    label = { Text(text = "Class") },
                    enabled = false,
                    readOnly = true,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )

                OutlinedTextField(
                    value = "Science",
                    onValueChange = {},
                    label = { Text(text = "Parent Phone") },
                    enabled = false,
                    readOnly = true,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                )
            }

            Box(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 52.dp, bottom = 16.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .fillMaxWidth()
                    .clickable {

                    },
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon_edit_profile),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(0.1f)
                    )

                    Text(
                        text = "Edit Profile",
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .weight(0.8f)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.ic_icon_arrow_right_rounded),
                        contentDescription = "",
                        modifier = Modifier
                            .weight(0.1f)
                    )
                }
            }

        }
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileBody()
}