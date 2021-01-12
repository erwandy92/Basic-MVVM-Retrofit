package com.erwandy.framework.basic_mvvm_retrofit.ui.main.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erwandy.framework.basic_mvvm_retrofit.data.repository.InfoRepository
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InfoViewModel(var infoRepository: InfoRepository) : ViewModel() {
    var userInfoLiveData = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    @SuppressLint("CheckResult")
    fun callInfo() {
        val result = StringBuffer()
        infoRepository.loadInfo()
                .subscribeOn(Schedulers.newThread())
                .map {
                    val sb = StringBuffer()
                    it.forEach { post ->
                        sb.append(post.body)
                        sb.append("\n")
                        sb.append("---------------------\n")
                    }
                    result.append(sb.toString())
                }
                .observeOn(AndroidSchedulers.mainThread())
                .compose(toggleLoading())
                .subscribe({
                    userInfoLiveData.setValue(it.toString())
                }, {
                    userInfoLiveData.setValue(result.toString())
                })
    }

    private fun <T> toggleLoading(): SingleTransformer<T, T> {
        return SingleTransformer { single ->
            single
                    .doOnSubscribe { loading.value = true }
                    .doFinally { loading.value = false }
        }
    }
}