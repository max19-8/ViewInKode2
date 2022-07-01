package com.example.viewinkode.newlitems

data class LayoutItem(
    val background: String,
    val height: Int,
    val id: Int,
    val layout: List<LayoutX>,
    val margin: Int,
    val padding: Int,
    val type:String,
    val width: Int
)