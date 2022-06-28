package com.example.viewinkode.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ButtonPrevious(
    val text: String,
    val action:Int
): Parcelable
