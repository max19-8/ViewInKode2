package com.example.viewinkode.sealed

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.setMargins
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.viewinkode.CreateNewScreen
import com.example.viewinkode.newlitems.LayoutItem
import com.example.viewinkode.newlitems.LayoutX
import com.example.viewinkode.setLayoutParams
import com.example.viewinkode.toDp

sealed class JsonItems {

    abstract fun createItem(): View

    class JsonImageView(
        private val context: Context,
        private val layoutX: LayoutX
    ) : JsonItems() {
        override fun createItem(): View {
            val imageView = ImageView(context)
            val imageParams = ViewGroup.LayoutParams(-1, -2)
            imageView.layoutParams = imageParams
            Glide.with(context)
                .load(layoutX.url)
                .transform(CenterInside(), RoundedCorners(layoutX.corner.toDp(context)))
                .into(imageView)
            return imageView
        }
    }

    class JsonTextView(private val layoutX: LayoutX, val context: Context) : JsonItems() {
        override fun createItem(): View {
            val textDetail: Spannable = SpannableString(layoutX.text)
            textDetail.setSpan(
                null,
                0,
                layoutX.text.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            val textView = TextView(context)
            textView.text = textDetail
            textView.gravity = Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK
            textView.textAlignment = View.TEXT_ALIGNMENT_GRAVITY
            textView.textSize = layoutX.textSize.toFloat()
            val params = setLayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                context
            )
            params.setMargins(16.toDp(context))
            textView.layoutParams = params
            return textView
        }
    }


    class JsonToolbar( private val context: Context,
                       private val layoutX: LayoutX,):JsonItems(){
        override fun createItem(): View {
            val toolbar = Toolbar(context)
            toolbar.setBackgroundColor(Color.parseColor(layoutX.background))
            toolbar.title = layoutX.text
            toolbar.setTitleTextColor(Color.parseColor(layoutX.textColor))
            return toolbar
        }

    }

    class JsonButton(
        private val context: Context,
        private val layoutItem: LayoutItem,
        private val layoutX: LayoutX,
        private val createNewScreen: CreateNewScreen
    ) : JsonItems() {
        override fun createItem(): View {
            val button = Button(context)
            button.text = layoutX.text
            button.setOnClickListener {
                val id = layoutItem.id + 1
                createNewScreen.createNewScreen(id)
                Log.d("createNewScreen", id.toString())
            }
            return button
        }
    }
}
