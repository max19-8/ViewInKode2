package com.example.viewinkode.sealed

import android.content.Context
import android.graphics.Color
import android.widget.LinearLayout
import com.example.viewinkode.newlitems.LayoutItem
import com.example.viewinkode.setLayoutParams

sealed class JsonLayouts{

    class JsonLinearLayout(){
        fun createLayout(context: Context,layoutItem: LayoutItem){
            val linear = LinearLayout(context)
            linear.orientation = LinearLayout.VERTICAL
            val linearParams = setLayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                context
            )
            linear.setBackgroundColor(Color.parseColor(layoutItem.background))
            linearParams.width = layoutItem.width
            linearParams.height = layoutItem.height
            linear.layoutParams = linearParams
        }
    }
}
