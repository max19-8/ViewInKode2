package com.example.viewinkode

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.viewinkode.data.model.Item
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var layout: List<Item>
    private lateinit var obj: CreateNewScreen
    private var factory:Factory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layout = CloudDataSource.Base(this.resources).getDataFromLocalJson()

        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)

         factory  = Factory(object : CreateNewScreen{
            override fun createNewScreen() {
                new()
            }

        })
        new()







//        val createNewScreen = object : CreateNewScreen{
//            override fun createNewScreen() {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, screen)
//                    .commit()
//            }
//
//        }



    }
    fun new(){
        val frag =  factory?.createScreen(this,layout.shuffled().first())
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, frag!!)
            .commit()
    }
}

