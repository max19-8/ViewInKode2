package com.example.viewinkode

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.viewinkode.data.model.Item
import com.example.viewinkode.newLayout.NextButton
import com.example.viewinkode.newLayout.NewImageView
import com.example.viewinkode.newLayout.NewTextView
import com.example.viewinkode.newLayout.PreviousButton


interface BaseLayout1{
    fun createBaseLayout(context: Context, item: Item, container: ScrollView):ViewGroup
}

abstract class CreateLayout:BaseLayout1{
  override  fun createBaseLayout(context: Context, item: Item, container: ScrollView):ViewGroup{
        val linear = LinearLayout(context)
        val toolbar = Toolbar(context)
        container.layoutParams = setLayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
            context
        )
        container.isScrollContainer = true
        container.isFillViewport = true
        toolbar.setBackgroundColor(Color.parseColor(item.title.background))
        toolbar.title = item.title.text
        toolbar.setTitleTextColor(Color.parseColor(item.title.textColor))
        linear.orientation = LinearLayout.VERTICAL
        val linearParams = setLayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            context
        )
        linear.setBackgroundColor(Color.parseColor(item.background))
        linearParams.height = LinearLayout.LayoutParams.MATCH_PARENT
        linearParams.width = LinearLayout.LayoutParams.MATCH_PARENT
        linear.layoutParams = linearParams


        val imageView = NewImageView().createImage(context,
            item.image.url,
            item.image.corner)

        val imageView2 = NewImageView().createImage( context,
            item.image2.url,
            item.image2.corner)

        val textView1 = NewTextView().createTextView(item.detailText.text,
            context,
            item.detailText.textSize.toFloat())

        val textView2 = NewTextView().createTextView(item.detailText2.text,
            context,
            item.detailText2.textSize.toFloat())
        linear.addView(toolbar)
        linear.addView(imageView)
        linear.addView(textView1)
        linear.addView(imageView2)
        linear.addView(textView2)
        container.addView(linear)
      return linear
    }

    private fun setLayoutParams(param1: Int, param2: Int, context: Context) =
        LinearLayout.LayoutParams(param1.toDp(context), param2.toDp(context))

   private  fun Int.toDp(context: Context): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
    ).toInt()


    class BaseLayout(private val createNewScreen: CreateNewScreen):CreateLayout(){
       override fun createBaseLayout(context: Context, item: Item, container: ScrollView):ViewGroup{
          val res =   super.createBaseLayout(context, item, container)
           val buttonPrevious = PreviousButton(createNewScreen).createButton(context,item)
           val buttonNext = NextButton(createNewScreen).createButton(context,item)
           res.addView(buttonPrevious)
           res.addView(buttonNext)
           return res
        }
    }
    class NextLayout(private val createNewScreen: CreateNewScreen):CreateLayout(){
        override fun createBaseLayout(context: Context, item: Item, container: ScrollView):ViewGroup{
            val res =  super.createBaseLayout(context, item, container)
            val button = if (item.id == 1)
                NextButton(createNewScreen).createButton(context, item)
            else
                PreviousButton(createNewScreen).createButton(context, item)
            res.addView(button)
            return res
        }
    }
}