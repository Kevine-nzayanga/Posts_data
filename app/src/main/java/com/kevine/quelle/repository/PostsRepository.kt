package com.kevine.quelle.repository

import androidx.lifecycle.LiveData
import com.kevine.quelle.api.ApiClient
import com.kevine.quelle.api.ApiInterface
import com.kevine.quelle.database.PostsDb
import com.kevine.quelle.model.PostData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostsRepository {

//    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

//    suspend fun  getPosts(): Response<PostData> {
//        return withContext(Dispatchers.IO){
//            apiClient.getPosts()
//        }
//
//}
}