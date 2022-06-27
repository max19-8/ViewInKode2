package com.example.viewinkode

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentOnAttachListener
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.viewinkode.data.model.Item
import com.google.android.material.snackbar.Snackbar


class Factory(private val createNewScreen: CreateNewScreen) {

    fun createScreen(context: Context, item: Item): Fragment {
        val fragment = BaseFragment()
            CreateLayout.BaseLayout(createNewScreen).createBaseLayout(context, item, fragment.container as ScrollView)
        return fragment
    }
    fun createNewScreen(context: Context, item: Item) :Fragment{
        val fragment = BaseFragment()
             CreateLayout.NextLayout(createNewScreen).createBaseLayout(context, item, fragment.container as ScrollView)
        return fragment
    }


    private fun createLayout(context: Context, item: Item, container: ScrollView):LinearLayout {
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

        val imageView = createImage(
            context,
            item.image.url,
            item.image.corner
        )
        val imageView2 = createImage(
            context,
            item.image2.url,
            item.image2.corner
        )

        val textView1 =
            createTextView(item.detailText.text, context, item.detailText.textSize.toFloat())
        val textView2 =
            createTextView(item.detailText2.text, context, item.detailText2.textSize.toFloat())
        val textView3 =
            createTextView(item.id.toString(), context, item.detailText2.textSize.toFloat())

        val button = Button(context)
        button.text = item.buttonNext.text

        button.setOnClickListener {
            Snackbar.make(linear,"${item.id}${"view id"}",Snackbar.LENGTH_LONG).show()
        }
        linear.addView(toolbar)
        linear.addView(imageView)
        linear.addView(textView1)
        linear.addView(imageView2)
        linear.addView(textView2)
        linear.addView(textView3)
        linear.addView(button)
        container.addView(linear)
        return linear
    }

    private fun createImage(
        context: Context,

        imageUrl: String,
        corner: Int
    ): ImageView {
        val imageView = ImageView(context)
        val imageParams =  ViewGroup.LayoutParams(-1, -2)
        imageView.layoutParams = imageParams

        Glide.with(context)
            .load(imageUrl)
            .transform(CenterInside(), RoundedCorners(corner.toDp(context)))
            .into(imageView)
        return imageView
    }

    private fun createTextView(text: String, context: Context, textSize: Float): TextView {
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



    private fun setLayoutParams(param1: Int, param2: Int, context: Context) =
        LinearLayout.LayoutParams(param1.toDp(context), param2.toDp(context))

    private fun Int.toDp(context: Context): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
    ).toInt()

    private fun createNextLayout(context: Context, item: Item, container: ScrollView,id:Int) {
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

        val imageView = createImage(
            context,
            item.image.url,
            item.image.corner
        )
        val imageView2 = createImage(
            context,
            item.image2.url,
            item.image2.corner
        )

        val textView1 =
            createTextView(item.detailText.text, context, item.detailText.textSize.toFloat())
        val textView2 =
            createTextView(item.detailText2.text, context, item.detailText2.textSize.toFloat())
        val textView3 =
            createTextView(item.id.toString(), context, item.detailText2.textSize.toFloat())

        val button = Button(context)
        button.text = item.buttonNext.text

        button.setOnClickListener {
            Snackbar.make(linear,"${item.id}${"view id"}",Snackbar.LENGTH_LONG).show()
        }

        linear.addView(toolbar)
        linear.addView(imageView)
        linear.addView(textView1)
        linear.addView(imageView2)
        linear.addView(textView2)
        linear.addView(textView3)
        linear.addView(button)
        container.addView(linear)
    }
}