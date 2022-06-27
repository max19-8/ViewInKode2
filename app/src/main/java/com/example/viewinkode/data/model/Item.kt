package com.example.viewinkode.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Item(
    val id:Int,
    val background: String,
    val buttonNext: Button,
    val detailText: DetailText,
    val image: Image,
    val title: Title,
    val image2: Image,
    val detailText2:DetailText
): Parcelable