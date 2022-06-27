package com.example.viewinkode.newLayout

import android.content.Context
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.viewinkode.CreateNewScreen
import com.example.viewinkode.data.model.Item

class NextButton(private val createNewScreen: CreateNewScreen) {
    fun createButton(context: Context,item:Item):Button{

        val button = Button(context)
//        button.text = item.buttonNext.text

        button.setOnClickListener {
           createNewScreen.createNewScreen()
            Log.d("createNewScreen",createNewScreen.createNewScreen().toString())
        }
        return button
    }
}
