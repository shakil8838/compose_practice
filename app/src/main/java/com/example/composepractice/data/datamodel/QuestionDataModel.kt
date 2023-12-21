package com.example.composepractice.data.datamodel

data class QuestionDataModel(
    val id: String = "",
    val userName: String = "",
    val uid: String = "",
    val dateTime: String = "",
    val question: String = "",
    val subjectId: String? = "",
    val chapterId: String? = "",
    val courseId: String? = "",
    val imageUrl: String? = "",
    val createdAt: String = "",
    val replies: List<ReplyDataModel>? = emptyList()
)
