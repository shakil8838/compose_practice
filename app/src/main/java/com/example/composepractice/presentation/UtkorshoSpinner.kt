package com.example.composepractice.presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.theme.colorPrimary100

@Composable
fun UtkorshoSpinner(
    modifier: Modifier = Modifier,
    items: List<String>,
    clickedItem: (String) -> Unit,
    preSelectedItem: String?
) {
    Spinner(
        modifier = modifier,
        items = items,
        clickedItem = clickedItem,
        preSelectedItem = preSelectedItem
    )
}

@Composable
private fun Spinner(
    modifier: Modifier = Modifier,
    items: List<String>,
    clickedItem: (String) -> Unit,
    preSelectedItem: String?
) {
    var selectedItem by remember { mutableStateOf(preSelectedItem ?: items[0]) }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {

        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorPrimary100, shape = RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            onClick = { expanded = true },
            content = {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = selectedItem,
                        style = TextStyle(color = Color.Black),
                        modifier = Modifier.weight(.99f)
                    )
                    Text(
                        "▼",
                        style = TextStyle(color = Color.Black),
                        modifier = Modifier.weight(.01f)
                    )
                }
            })

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth(.9f)
                .background(color = colorPrimary100, shape = RoundedCornerShape(8.dp))
        ) {
            items.forEach { item ->
                DropdownMenuItem(onClick = {
                    selectedItem = item
                    expanded = false
                    clickedItem(item)
                }, text = { Text(text = item) })
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SpinnerPreview() {
    Spinner(
        items = listOf("Select", "Item 1", "Item 2", "Item 3"),
        clickedItem = {
            Log.d("Spinner", "Spinner: $it")
        },
        preSelectedItem = "Item 2"
    )
}