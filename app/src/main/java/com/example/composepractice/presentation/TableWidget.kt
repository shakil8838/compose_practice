package com.example.composepractice.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.composepractice.ui.theme.ColorSecondary
import com.example.composepractice.ui.theme.colorPrimary
import com.example.composepractice.ui.theme.fontSize12
import com.example.composepractice.ui.theme.fontWeight400
import com.example.composepractice.ui.theme.fontWeight700

private const val TAG = "TableWidget"

@Composable
fun TableWidget(listOfRoutineData: List<Any>, onClassItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = ColorSecondary,
                        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
                    ),
            ) {
                Text(
                    text = "DATE",
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = fontSize12,
                    fontWeight = fontWeight700
                )

                Text(
                    text = "TIME",
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = fontSize12,
                    fontWeight = fontWeight700
                )

                Text(
                    text = "ITEM",
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = fontSize12,
                    fontWeight = fontWeight700
                )
            }

            TableData(
                routineList = listOfRoutineData,
                onClassItemClick = onClassItemClick
            )
        }
    }

}

@Composable
private fun TableData(routineList: List<Any>, onClassItemClick: () -> Unit) {
    LazyColumn(content = {
        items(routineList.size) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
            ) {
                Text(
                    text = "Hello", // index.date()
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = fontSize12,
                    fontWeight = fontWeight400
                )
                Text(
                    text = "World", // index.time()
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontSize = fontSize12,
                    fontWeight = fontWeight400
                )
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .clickable {
                            Log.e(TAG, "TableData: Clicked")
                            onClassItemClick()
                        },
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,

                    ) {
                    Text(
                        text = "M1 - 01", // index.className()
                        color = colorPrimary,
                        textAlign = TextAlign.Center,
                        fontSize = fontSize12,
                        fontWeight = fontWeight400,
                    )

                    Spacer(modifier = Modifier.width(24.dp))

                    Image(
                        painter = painterResource(id = R.drawable.ic_icon_arrow_right),
                        contentDescription = null
                    )
                }
            }
        }
    })

//    for (i in routineList.indices) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(color = Color.White),
//        ) {
//            Text(
//                text = "Hello", // i.date()
//                color = Color.Black,
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(16.dp),
//                textAlign = TextAlign.Center,
//                fontSize = fontSize12,
//                fontWeight = fontWeight400
//            )
//            Text(
//                text = "World", // i.time()
//                color = Color.Black,
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(16.dp),
//                textAlign = TextAlign.Center,
//                fontSize = fontSize12,
//                fontWeight = fontWeight400
//            )
//            Row(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(16.dp)
//                    .clickable {
//                        Log.e(TAG, "TableData: Clicked")
//                        // startActivity(context,
//                        // Intent(context, LiveActivity::class.java)
//                        // .putExtra("class", i.classUrl())
//                        // )
//                    },
//                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
//
//                ) {
//                Text(
//                    text = "M1 - 01", // i.className()
//                    color = colorPrimary,
//                    textAlign = TextAlign.Center,
//                    fontSize = fontSize12,
//                    fontWeight = fontWeight400,
//                )
//
//                Spacer(modifier = Modifier.width(24.dp))
//
//                Image(
//                    painter = painterResource(id = R.drawable.ic_icon_arrow_right),
//                    contentDescription = null
//                )
//            }
//        }
//    }
}

@Composable
@Preview(showSystemUi = true)
fun previewTableWidget() {
    TableWidget(listOfRoutineData = listOf("Hello", "World")) {

    }
}

@Composable
@Preview
fun previewTableData() {

}