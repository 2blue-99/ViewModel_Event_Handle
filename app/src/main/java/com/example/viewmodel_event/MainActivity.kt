package com.example.viewmodel_event

import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.findNavController
import com.example.viewmodel_event.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun setData() {

    }

    override fun setObserver() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event ->
                Log.e("TAG", "event : $event", )
                when(event){
                    is MyEvent.ShowToast -> { showToast(event.message) }
                    is MyEvent.ShowPopup -> { showDialog(event) }
                    is MyEvent.MovePage -> { findNavController(event.id) }
                    else -> {  }
                }
            }
        }
    }

    override fun setListener() {

    }
}