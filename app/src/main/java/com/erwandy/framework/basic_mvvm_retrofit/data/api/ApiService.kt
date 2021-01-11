package com.erwandy.framework.basic_mvvm_retrofit.data.api

import com.erwandy.framework.basic_mvvm_retrofit.data.model.Posts
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @GET("/posts")
    fun getPosts(): Single<List<Posts>>
}