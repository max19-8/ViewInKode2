package com.example.viewinkode

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.viewinkode.data.model.Item
import com.example.viewinkode.newlitems.LayoutItem
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var layout: List<Item>
    private var factory: Factory? = null
    private lateinit var newItems:List<LayoutItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = CloudDataSource.Base(this.resources).getDataFromLocalJson()
         newItems = CloudDataSource.New(this.resources).getDataFromLocalJson()
        println(newItems)
         factory = Factory(object : CreateNewScreen{
            override fun createNewScreen(id: Int) {
                new(newItems.first{
                    it.id == id
                })
            }

        })
       new(newItems.shuffled().first())


//
//         factory  = Factory(object : CreateNewScreen{
//            override fun createNewScreen(id:Int) {
//                new(layout.first{
//                    it.id == id
//                })
//            }
//        })
     //   new(layout.first())
    }



      private  fun new(item: LayoutItem){
        val frag =  factory?.createCreate(item,this)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, frag!!)
            .commit()
    }


//  private  fun new(item: Item){
//        val frag =  factory?.newScreenCreate(this,item)
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, frag!!)
//            .commit()
//    }



    }


