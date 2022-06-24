package com.example.viewinkode.createview

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.TextView


 abstract class AbstractView(context: Context) : View(context) {
     fun getSize(size:Int):Float =
           TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, size.toFloat(), context.resources.displayMetrics)
 }

class Title(context: Context):AbstractView(context){
     fun createView(text:String,textSize:Int):TextView {
        val title = TextView(context)
        title.text = text
        title.textSize =  getSize(textSize)
        return title
    }
}

//class ImageView(context: Context):View{
//    private lateinit var imageButton:View
//    override fun createView() {
//        imageButton = ImageView()
//        println("CreateImageView")
//    }
//}