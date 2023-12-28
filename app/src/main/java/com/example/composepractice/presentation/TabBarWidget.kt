package com.example.composepractice.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class Tab {
    tab1, tab2, tab3, tab4
}

@Composable
fun TabBar(tabNames: Array<String>) {

    var selectedTab by remember { mutableStateOf(Tab.tab1) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TabRow(
            selectedTabIndex = selectedTab.ordinal,
            modifier = Modifier.fillMaxWidth()
        ) {

            for (i in tabNames.indices) {
                Tab(
                    selected = selectedTab.ordinal == i,
                    onClick = { selectedTab = Tab.entries.toTypedArray()[i] },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(tabNames[i], modifier = Modifier.padding(8.dp))
                }
            }
//            Tab(
//                selected = selectedTab == Tab.tab1,
//                onClick = { selectedTab = Tab.tab1 },
//                modifier = Modifier.padding(8.dp)
//            ) {
//                Text("সংক্ষিপ্ত বর্ণনা")
//            }
//            Tab(
//                selected = selectedTab == Tab.tab2,
//                onClick = { selectedTab = Tab.tab2 },
//                modifier = Modifier.padding(8.dp)
//            ) {
//                Text("ক্লাস রুটিন")
//            }
//            Tab(
//                selected = selectedTab == Tab.tab3,
//                onClick = { selectedTab = Tab.tab3 },
//                modifier = Modifier.padding(8.dp)
//            ) {
//                Text("রিপোর্ট")
//            }
//            Tab(
//                selected = selectedTab == Tab.tab4,
//                onClick = { selectedTab = Tab.tab4 },
//                modifier = Modifier.padding(8.dp)
//            ) {
//                Text("রিসোর্স")
//            }
        }
    }

//    Spacer(modifier = Modifier.height(16.dp))

    when (selectedTab) {
        Tab.tab1 -> BriefContent()
        Tab.tab2 -> RoutineContent()
        Tab.tab3 -> ReportContent()
        Tab.tab4 -> ResourceContent()
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