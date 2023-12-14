package com.example.composepractice.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.theme.colorPrimary

@Composable
fun CommentWidget(onSendClicked: (comment: String) -> Unit) {

    var text by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        BasicTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            singleLine = true,
            textStyle = TextStyle(

            ), //MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onSend = {
                    // TODO: Handle send action
                    onSendClicked("userComment")
                }
            ),
            decorationBox = {
                if (text.isEmpty()) {
                    Text(
                        text = "Your comment...",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        )

        IconButton(
            onClick = {
                // TODO: Handle button click
                onSendClicked("userComment2")
            },
            modifier = Modifier
                .size(40.dp)
                .padding(4.dp),
        ) {
            Icon(imageVector = Icons.Default.Send, contentDescription = "Send", tint = colorPrimary)
        }
    }
}

@Composable
@Preview
fun PreviewCommentWidget() {
    CommentWidget(onSendClicked = {

    })
}