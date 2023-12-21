package com.example.composepractice.data.datamodel

data class ReplyDataModel(
    val id: String? = "",
    val questionId: String = "",
    val uid: String = "",
    val userName: String = "",
    val dateTime: String = "",
    val reply: String = "",
    val createdAt: String = "",
    val imageUrl: String? = "",
)
