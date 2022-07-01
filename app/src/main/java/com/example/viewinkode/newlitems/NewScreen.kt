package com.example.viewinkode.newlitems

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import com.example.viewinkode.CreateNewScreen
import com.example.viewinkode.mappers.ItemsMapper

class NewScreen(private val createNewScreen: CreateNewScreen) {

    private val itemsMapper = ItemsMapper()

    fun createNewItem(layoutItem: LayoutItem,context: Context,container: ScrollView):ViewGroup{
        val type = layoutItem.type
    val layout :LinearLayout =  when(type){
            "linearLayout" -> LinearLayout(context)
        else -> LinearLayout(context)
    }
        container.layoutParams = setLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
            context
        )
        container.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        container.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        container.isScrollContainer = true
        container.isFillViewport = true
        layout.orientation = LinearLayout.VERTICAL
        val linearParams = setLayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            context
        )
        layout.setBackgroundColor(Color.parseColor(layoutItem.background))
        linearParams.height = LinearLayout.LayoutParams.MATCH_PARENT
        linearParams.width = LinearLayout.LayoutParams.MATCH_PARENT
        layout.layoutParams = linearParams

        val items = layoutItem.layout

        for (i in items){
          val result =  itemsMapper.mapEnum(i)
            layout.addView(itemsMapper.map(i,context,result,layoutItem,createNewScreen))
          }
        container.addView(layout)
        return layout
    }



    private fun setLayoutParams(param1: Int, param2: Int, context: Context) =
        LinearLayout.LayoutParams(param1.toDp(context), param2.toDp(context))

    private  fun Int.toDp(context: Context): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
    ).toInt()
}