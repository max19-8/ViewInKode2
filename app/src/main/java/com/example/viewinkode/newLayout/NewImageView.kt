package com.example.viewinkode.newLayout

import android.content.Context
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class NewImageView {
     fun createImage(
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
    private fun Int.toDp(context: Context): Int = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics
    ).toInt()


}