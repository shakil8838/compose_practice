package com.example.composepractice.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.R
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposePracticeTheme {
//                Column {
//                    TopAppBar(title = { Text(text = "সংক্ষিপ্ত বর্ণনা") })
//                    TabBar(tabNames = arrayOf("সংক্ষিপ্ত বর্ণনা", "ক্লাস রুটিন"))
//                }
//            }
            CollapsingAppBar()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CollapsingAppBar() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    var itemList by remember {
        mutableStateOf(emptyList<Unit>())
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(text = "Eitai title", color = Color.Black) },
                modifier = Modifier.background(Color.Transparent),
                scrollBehavior = scrollBehavior,
            )
        },
//        content = {
//            Column(
//                Modifier.fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                val lazyListState = rememberLazyListState()
//                var scrolledY = 0f
//                var previousOffset = 0
//
//                Image(
//                    painter = painterResource(id = R.drawable.ic_img_illustration_physics),
//                    contentDescription = null,
//                    contentScale = ContentScale.FillWidth,
//                    modifier = Modifier
////                        .graphicsLayer {
////                            scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
////                            translationY = scrolledY * 0.5f
////                            previousOffset =
////                                lazyListState.firstVisibleItemScrollOffset
////                        }
////                        .height(300.dp)
//                        .fillMaxWidth()
//                )
//                TabBar(tabNames = arrayOf("সংক্ষিপ্ত বর্ণনা", "ক্লাস রুটিন"))
//            }
//        }
        content = {

            LazyColumn(
                content = {
                    item {
                    ChatSimpleText("")
                    }
                    item {
                        AuthOption{
                            if (it == 0){
                                
                            }
                        }
                    }

                },
                modifier = Modifier.padding(top = 60.dp),
            )
        }
    )
}

@Composable
fun BoxImage(
    modifier: Modifier = Modifier,
    containerDescription: String,
    title: String,
    painter: Painter
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = containerDescription,
                contentScale = ContentScale.Crop,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color.Black),
                        startY = 300f
                    ),
                )
        )

    }

}

@Preview
@Composable
fun ColumnTextsPreview() {
    ComposePracticeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            CollapsingAppBar()
        }
    }
}