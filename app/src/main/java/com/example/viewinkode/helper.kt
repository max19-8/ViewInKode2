package com.example.viewinkode

import android.content.Context
import android.util.TypedValue
import android.widget.LinearLayout

 fun setLayoutParams(param1: Int, param2: Int, context: Context) =
    LinearLayout.LayoutParams(param1.toDp(context), param2.toDp(context))

  fun Int.toDp(context: Context): Int = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
).toInt()