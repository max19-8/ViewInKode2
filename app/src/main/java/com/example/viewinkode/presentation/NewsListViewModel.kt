package com.example.viewinkode.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.viewinkode.CloudDataSource
import com.example.viewinkode.data.model.Item

class NewsListViewModel(application: Application):AndroidViewModel(application) {
  private  val dataSource: CloudDataSource = CloudDataSource.Base(application.resources)
    private var _items = MutableLiveData<List<Item>>()
     val items get() = _items

    init {
        getNews()
    }

  private  fun getNews(){
      _items.value = dataSource.getDataFromLocalJson()
    }
}