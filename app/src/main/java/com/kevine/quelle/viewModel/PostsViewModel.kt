package com.kevine.quelle.viewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kevine.quelle.model.PostData
import com.kevine.quelle.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel:ViewModel() {
    var postsRepo = PostsRepository()
    val postsLiveData  = MutableLiveData<List<PostData>>()
    val errorLiveData = MutableLiveData<String>()


    fun fetchPosts(){
        viewModelScope.launch {
            val response = postsRepo.getPosts()

            if (response.isSuccessful){
                val postsLists = response.body() ?: emptyList()

                postsLiveData.postValue(postsLists as List<PostData>)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}