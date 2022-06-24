package com.example.viewinkode.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailText(
    val text: String,
    val textColor: String,
    val textSize: Int
):Parcelable