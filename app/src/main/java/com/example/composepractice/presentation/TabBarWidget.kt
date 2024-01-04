package com.example.composepractice.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabBar(tabNames: Array<String>) {

    var selectedTab by remember { mutableStateOf(0) }
    val pageState = rememberPagerState {
        tabNames.size
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (i in tabNames.indices) {
                Tab(
                    selected = selectedTab == i,
                    onClick = { selectedTab = i },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(tabNames[i], modifier = Modifier.padding(8.dp))
                }
            }
        }
    }

    HorizontalPager(
        state = pageState,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp)
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            when (page) {
                0 -> {
                    BriefContent()
                    selectedTab = page
                }

                1 -> {
                    RoutineContent()
                    selectedTab = page
                }

                2 -> {
                    ReportContent()
                    selectedTab = page
                }

                3 -> {
                    ResourceContent()
                    selectedTab = page
                }
            }
        }

    }
}

@Composable
fun BriefContent() {
    BriefCard(
        title = "কোর্স টাইটেল",
        courseTitle = "কোর্স টাইটেল",
        description = "কোর্স টাইটেল",
        duration = "কোর্স টাইটেল",
        subjectListList = listOf("কোর্স টাইটেল", "কোর্স টাইটেল", "কোর্স টাইটেল")
    )
}

@Composable
fun RoutineContent() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        //TableWidget()
    }
}

@Composable
fun ReportContent() {

}

@Composable
fun ResourceContent() {

}

@Preview(showSystemUi = true)
@Composable
fun PreviewTabBar() {
    TabBar(arrayOf("সংক্ষিপ্ত বর্ণনা", "ক্লাস রুটিন"))
}