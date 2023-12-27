package com.example.composepractice.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.R

@Composable
fun EditProfileScreen() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreenContent() {

    var selectedItem by remember { mutableStateOf("Item 1") }
    var expanded by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        item {

            Image(painter = painterResource(id = R.drawable.ic_icon_send), contentDescription = "")

            OutlinedTextField(
                value = "Science",
                onValueChange = {},
                enabled = false,
                readOnly = true,
                label = { Text(text = "Name") },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth()
            )

            OutlinedTextField(
                value = "+8801234567890",
                onValueChange = {},
                enabled = false,
                readOnly = true,
                label = { Text(text = "Phone") },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview
fun EditProfileScreenPreview() {
    EditProfileScreen()
}

@Composable
@Preview
fun EditProfileScreenContentPreview() {
    EditProfileScreenContent()
}