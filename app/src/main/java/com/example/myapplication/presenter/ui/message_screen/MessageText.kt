package com.example.myapplication.presenter.ui.message_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MessageText(msg: String) {
    Box(contentAlignment = Alignment.Center) {
        Text(text = msg)
    }
}

@Preview(showBackground = true)
@Composable
fun MessageTextPreview() {
    Text(text = "Welcome in Gym App")
}