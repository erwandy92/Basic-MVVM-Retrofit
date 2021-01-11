package com.erwandy.framework.basic_mvvm_retrofit.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erwandy.framework.basic_mvvm_retrofit.data.model.UserData
import com.erwandy.framework.basic_mvvm_retrofit.data.repository.InfoRepository
import com.erwandy.framework.basic_mvvm_retrofit.data.repository.OnTaskFinish

class InfoViewModel (var infoRepository: InfoRepository): ViewModel() {
    private var userInfoLiveData = MutableLiveData<UserData>()
    fun callInfo(): LiveData<UserData> {
        infoRepository.loadInfo(object : OnTaskFinish {
            override fun onFinish(data: UserData) {
                userInfoLiveData.postValue(data)
            }
        })
        return userInfoLiveData
    }
}