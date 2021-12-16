package com.sumanta.loincompose.ui.retrofit.network

import com.sumanta.loincompose.ui.retrofit.data.Post
import retrofit2.http.GET

interface ApiService {

    companion object{
        const val BSE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPost():List<Post>

}