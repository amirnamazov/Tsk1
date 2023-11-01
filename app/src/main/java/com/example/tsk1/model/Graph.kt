package com.example.tsk1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Graph(
    val id: Int,
    val title: String,
    val colorId: Int? = null
) : Parcelable