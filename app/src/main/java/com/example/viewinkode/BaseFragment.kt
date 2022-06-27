package com.example.viewinkode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.fragment.app.Fragment

class BaseFragment : Fragment() {
    var container:View = ScrollView(App.appContext)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return this.container
    }

    fun newLayout(view: View){
        this.container = view
    }

}