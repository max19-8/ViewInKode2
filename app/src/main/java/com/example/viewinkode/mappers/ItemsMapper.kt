package com.example.viewinkode.mappers

import android.content.Context
import android.view.View
import com.example.viewinkode.CreateNewScreen
import com.example.viewinkode.newlitems.LayoutItem
import com.example.viewinkode.newlitems.LayoutX
import com.example.viewinkode.sealed.JsonItems

class ItemsMapper {

    fun mapEnum(layoutX: LayoutX):TypeItems {
        return when(layoutX.tag){
            "imageView" -> TypeItems.IMAGE_VIEW
            "textView" -> TypeItems.TEXT_VIEW
            "title" -> TypeItems.TITLE
            "toolbar"-> TypeItems.TOOLBAR
            else -> TypeItems.BUTTON
        }
    }


    fun map(layoutX: LayoutX,context: Context,typeItems: TypeItems,layoutItem: LayoutItem,createNewScreen: CreateNewScreen):View{
       return when(typeItems){
           TypeItems.IMAGE_VIEW ->  JsonItems.JsonImageView(context, layoutX).createItem()
               TypeItems.TEXT_VIEW ->  JsonItems.JsonTextView(layoutX,context).createItem()
           TypeItems.TITLE ->  JsonItems.JsonTextView(layoutX,context).createItem()
           TypeItems.TOOLBAR -> JsonItems.JsonToolbar(context, layoutX).createItem()
            TypeItems.BUTTON-> JsonItems.JsonButton(context,layoutItem,layoutX,createNewScreen).createItem()
       }
    }
}