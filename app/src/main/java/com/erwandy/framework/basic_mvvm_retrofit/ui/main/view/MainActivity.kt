package com.erwandy.framework.basic_mvvm_retrofit.ui.main.view

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.erwandy.framework.basic_mvvm_retrofit.R
import com.erwandy.framework.basic_mvvm_retrofit.data.repository.InfoRepository
import com.erwandy.framework.basic_mvvm_retrofit.databinding.ActivityMainBinding
import com.erwandy.framework.basic_mvvm_retrofit.ui.base.InfoFactory
import com.erwandy.framework.basic_mvvm_retrofit.ui.main.viewmodel.InfoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var infoViewModel: InfoViewModel
    private lateinit var infoFactory: InfoFactory
    private lateinit var infoRepository: InfoRepository

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        infoRepository = InfoRepository()
        infoFactory = InfoFactory(infoRepository)
        infoViewModel = ViewModelProvider(this, infoFactory).get(InfoViewModel::class.java)

        binding.sendData.setOnClickListener {
            val dialog = ProgressDialog.show(
                    this, "",
                    "Loading. Please wait...", true
            )
            dialog.show()
            infoViewModel.callInfo().observe(this, Observer {
                dialog.dismiss()
                binding.info.text = it
            })
        }
    }
}