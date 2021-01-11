package com.erwandy.framework.basic_mvvm_retrofit.data.repository

import com.erwandy.framework.basic_mvvm_retrofit.data.api.ApiService
import com.erwandy.framework.basic_mvvm_retrofit.data.api.AppClientManager
import com.erwandy.framework.basic_mvvm_retrofit.data.model.Posts
import io.reactivex.Single

class InfoRepository {
    private val apiService = AppClientManager.client.create(ApiService::class.java)
    fun loadInfo(): Single<List<Posts>> {
        return apiService.getPosts()
    }
}
