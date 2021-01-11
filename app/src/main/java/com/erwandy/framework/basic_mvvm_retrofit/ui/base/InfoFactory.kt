package com.erwandy.framework.basic_mvvm_retrofit.ui.base

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.erwandy.framework.basic_mvvm_retrofit.data.repository.InfoRepository
import com.erwandy.framework.basic_mvvm_retrofit.ui.main.viewmodel.InfoViewModel


class InfoFactory(private var infoRepository: InfoRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(@NonNull modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InfoViewModel::class.java)) {
            return InfoViewModel(infoRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}