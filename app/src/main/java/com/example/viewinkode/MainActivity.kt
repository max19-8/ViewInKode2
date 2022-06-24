package com.example.viewinkode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layout = CloudDataSource.Base(this.resources).getDataFromLocalJson()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.container)
        if (currentFragment == null) {
            val screen = Factory.createScreen(this,layout.shuffled().first())
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, screen)
                .commit()
        }
    }
}