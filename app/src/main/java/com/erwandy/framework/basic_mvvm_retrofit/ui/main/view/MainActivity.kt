@file:Suppress("DEPRECATION")

package com.erwandy.framework.basic_mvvm_retrofit.ui.main.view

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.erwandy.framework.basic_mvvm_retrofit.databinding.ActivityMainBinding
import com.erwandy.framework.basic_mvvm_retrofit.ui.main.viewmodel.InfoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val infoViewModel: InfoViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val dialog = ProgressDialog.show(
                this, "",
                "Loading. Please wait...", true
        )
        dialog.hide()
        infoViewModel.userInfoLiveData.observe(this, Observer {
            binding.info.text = it
            if(dialog.isShowing){
                dialog.hide()
            }
        })
        binding.sendData.setOnClickListener {
            dialog.show()
            infoViewModel.callInfo()
        }
    }
}