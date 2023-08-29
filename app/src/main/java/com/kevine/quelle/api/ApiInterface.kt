package com.kevine.quelle.api

import com.kevine.quelle.model.PostData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface ApiInterface {
        @GET("/posts")
       suspend fun getPosts(): Response<List<PostData>>


}