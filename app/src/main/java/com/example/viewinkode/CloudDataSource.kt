package com.example.viewinkode

import android.content.res.Resources
import android.util.Log
import com.example.viewinkode.data.model.Items
import com.example.viewinkode.data.model.Item
import com.example.viewinkode.newlitems.LayoutItem
import com.example.viewinkode.newlitems.Layouts
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

interface CloudDataSource {
     fun getDataFromLocalJson(): List<Item>

    class Base(private val resources: Resources) : CloudDataSource {

        override   fun getDataFromLocalJson(): List<Item> {
            return try {
                    val jsonString =
                        resources.openRawResource(R.raw.item_list).bufferedReader().use {
                            it.readText()
                        }
                    val typeToken = object : TypeToken<Items>() {}.type
                    Log.d("CloudDataSource", jsonString)
                     Gson().fromJson(jsonString, typeToken)

            } catch (e: Exception) {
                Log.d("CloudDataSource", e.toString())
                emptyList()
            }
        }
    }

    class New(private val resources: Resources)  {

           fun getDataFromLocalJson(): List<LayoutItem> {
            return try {
                val jsonString =
                    resources.openRawResource(R.raw.new_json).bufferedReader().use {
                        it.readText()
                    }
                val typeToken = object : TypeToken<Layouts>() {}.type
                Log.d("CloudDataSource", jsonString)
                Gson().fromJson(jsonString, typeToken)

            } catch (e: Exception) {
                Log.d("CloudDataSource", e.toString())
                emptyList()
            }
        }
    }
}