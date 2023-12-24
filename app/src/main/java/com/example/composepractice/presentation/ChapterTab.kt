package com.example.composepractice.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.composepractice.R
import com.example.composepractice.ui.theme.ColorSecondary
import com.example.composepractice.ui.theme.colorPrimary
import kotlin.math.PI


@Composable
fun ChapterLists() {
    LazyColumn(content = {
        items(10) {
            ChapterCard()
        }
    })
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ChapterCard() {
    Row(
        modifier = Modifier
            .padding(start = 0.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {

        Box(modifier = Modifier
            .drawBehind { customStepper() }
            .weight(.2f),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Text(text = "100%")
        }

        Box(
            modifier = Modifier
                .weight(.8f)
                .height(208.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = Color.LightGray)
        ) {
            Column {
                GlideImage(
                    model = "https://as2.ftcdn.net/v2/jpg/05/61/80/91/1000_F_561809156_f9q3rF0eD2G1opqV386jW4o48fpsZBrK.jpg",
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.FillBounds,
                )

                Row {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(.8f)
                    ) {
                        Text(
                            text = "P1 - 01",
                            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W500)
                        )
                        Text(
                            text = "ভেক্টর ও স্কেলার",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W700)
                        )
                    }

                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.padding(8.dp),
                        border = BorderStroke(1.dp, colorPrimary)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_icon_arrow_next),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}

fun DrawScope.customStepper() {

    val center = Offset(size.width / 2, size.height / 2)
    val radius = (size.width / 3.5f)

//    drawLine(
//        color = colorPrimary,
//        start = Offset(size.width / 2, -size.height * 6),
//        end = Offset(size.width / 2, size.height * 7),
//        strokeWidth = 4f,
//        cap = StrokeCap.Round
//    )

    drawLine(
        color = colorPrimary,
        start = Offset(size.width / 2, -size.height * 5.33f),
        end = Offset(size.width / 2, size.height - 130),
        strokeWidth = 4f,
        cap = StrokeCap.Round
    )

    drawLine(
        color = colorPrimary,
        start = Offset(size.width / 2, size.height + 80),
        end = Offset(size.width / 2, size.height * 7),
        strokeWidth = 4f,
        cap = StrokeCap.Round
    )

    drawCircle(
        color = ColorSecondary,
        radius = radius,
        center = Offset(size.width / 2, size.height / 2)
    )

//    drawArc(
//        color = colorPrimary,
//        startAngle = 90f,
//        sweepAngle = (360).toFloat(),
//        useCenter = false,
//        size = Size(90f, 360f),
//    )
    val componentSize = size / 1.25f
    drawArc(
        size = componentSize,
        color = colorPrimary,
        startAngle = 150f,
        sweepAngle = 100f,
        useCenter = false,
        style = Stroke(
            width = 5f,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )

    drawCircle(center = center, radius = radius - 10f, color = Color.White)


}

@Composable
@Preview
fun ChapterCardPreview() {
    ChapterCard()
}

//@Composable
//@DevicePreview
//fun ChapterListPreview() {
//    ChapterLists()
//}