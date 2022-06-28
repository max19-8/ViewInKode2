package com.example.viewinkode.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ButtonNext(
    val text: String,
    val action:Int
):Parcelable