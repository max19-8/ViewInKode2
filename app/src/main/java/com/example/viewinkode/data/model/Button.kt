package com.example.viewinkode.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Button(
    val background: String,
    val height: Int,
    val text: String,
    val width: Int
):Parcelable