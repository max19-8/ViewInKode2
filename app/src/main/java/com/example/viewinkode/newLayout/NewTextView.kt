package com.example.viewinkode.newLayout

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setMargins
import com.example.viewinkode.setLayoutParams
import com.example.viewinkode.toDp

class NewTextView {
     fun createTextView(text: String, context: Context, textSize: Float): TextView {
        val textDetail: Spannable = SpannableString(text)
        textDetail.setSpan(
            null,
            0,
            text.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        textDetail.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            text.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        val textView = TextView(context)
        textView.text = textDetail
        textView.gravity = Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK
        textView.textAlignment = View.TEXT_ALIGNMENT_GRAVITY
        textView.textSize = textSize
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