package com.example.core.data

data class CreatedBy(
    val id: Int,
    val credit_id: String,
    val name: String,
    val gender: Gender,
    val profile_path: String?
)
