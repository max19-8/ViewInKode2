package com.example.viewinkode

import android.content.Context
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.viewinkode.data.model.Item
import com.example.viewinkode.newlitems.LayoutItem
import com.example.viewinkode.newlitems.NewScreen


class Factory(
    private val createNewScreen: CreateNewScreen
    ) {

//    fun newScreenCreate(context: Context, item: Item):Fragment{
//       return if (item.id == 1 || item.id == 4){
//           createNewScreen(context, item)
//        }else{
//           createScreen(context, item)
//        }
//    }

    fun createCreate(layoutItem: LayoutItem, context: Context):Fragment{
        val fragment = BaseFragment()
        NewScreen(createNewScreen).createNewItem(layoutItem,context, fragment.container as ScrollView)
        return fragment
    }

//   private fun createScreen(context: Context, item: Item): Fragment {
//        val fragment = BaseFragment()
//            CreateLayout.BaseLayout(createNewScreen).createBaseLayout(context, item, fragment.container as ScrollView)
//        return fragment
//    }
//     private fun createNewScreen(context: Context, item: Item) :Fragment{
//        val fragment = BaseFragment()
//             CreateLayout.NextLayout(createNewScreen).createBaseLayout(context, item, fragment.container as ScrollView)
//        return fragment
//    }
//
//    private fun buttonClick(context: Context, item: Item):Fragment{
//        val fragment = BaseFragment()
//        CreateLayout.NextLayout(createNewScreen).createBaseLayout(context, item, fragment.container as ScrollView)
//        return fragment
//    }
}