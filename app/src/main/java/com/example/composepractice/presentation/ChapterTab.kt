package com.example.composepractice.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composepractice.ui.theme.ColorSecondary
import com.example.composepractice.ui.theme.colorPrimary


@Composable
fun ChapterLists() {

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ChapterCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {

        Box(modifier = Modifier
            .drawBehind { customStepper() }
            .weight(.2f),
//            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 8.dp),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Text(text = "100%")
        }

        Box(
            modifier = Modifier
                .weight(.8f)
                .background(color = Color.White)
        ) {
            Column {
                GlideImage(
                    model = "https://as2.ftcdn.net/v2/jpg/05/61/80/91/1000_F_561809156_f9q3rF0eD2G1opqV386jW4o48fpsZBrK.jpg",
                    contentDescription = "",
                    modifier = Modifier.clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}

fun DrawScope.customStepper() {

    val center = Offset(size.width / 2, size.height / 2)
    val radius = (size.width / 3)

    drawLine(
        color = colorPrimary,
        start = Offset(size.width / 2, -size.height),
        end = Offset(size.width / 2, size.height + 50),
        strokeWidth = 2f
    )

    drawCircle(
        color = ColorSecondary,
        radius = radius,
        center = Offset(size.width / 2, size.height / 2)
    )

    drawCircle(center = center, radius = radius-10f, color = Color.White);

}

@Composable
@Preview
fun ChapterCardPreview() {
    ChapterCard()
}