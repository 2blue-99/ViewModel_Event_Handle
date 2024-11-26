package com.example.viewmodel_event

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    @get:LayoutRes
    abstract val layoutId: Int
    protected abstract val viewModel: VM
    lateinit var binding: VB

    /**
     * onCreate
     */
    abstract fun setData()
    /**
     * onCreate
     */
    abstract fun setObserver()
    /**
     * onCreate
     */
    abstract fun setListener()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.apply {
//            binding.setVariable(BR.viewModel, this@BaseActivity)
            lifecycleOwner = this@BaseActivity
        }

        setData()
        setObserver()
        setListener()
    }

    private fun setDataBinding(){

    }

    fun showToast(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun showDialog(popupContent: PopupContent, callback: () -> Unit = {}){
        AlertDialog.Builder(this)
            .setTitle(popupContent.name)
            .show()
    }
}