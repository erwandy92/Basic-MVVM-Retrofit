package com.erwandy.framework.basic_mvvm_retrofit.data.repository

import com.erwandy.framework.basic_mvvm_retrofit.data.api.ApiService
import com.erwandy.framework.basic_mvvm_retrofit.data.api.AppClientManager
import com.erwandy.framework.basic_mvvm_retrofit.data.model.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoRepository {
    fun loadInfo(task: OnTaskFinish) {
        val apiService = AppClientManager.client.create(ApiService::class.java)
        apiService.getPosts().enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                val sb = StringBuffer()
                response.body()?.forEach {
                    sb.append(it.body)
                    sb.append("\n")
                    sb.append("---------------------\n")
                }
                task.onFinish(sb.toString())
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

            }
        })
    }
}
interface OnTaskFinish {
    fun onFinish(data: String)
}
