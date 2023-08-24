package com.kevine.quelle.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kevine.quelle.PostsrvAdapter
import com.kevine.quelle.R
import com.kevine.quelle.api.ApiClient
import com.kevine.quelle.api.ApiInterface
import com.kevine.quelle.databinding.ActivityMainBinding
import com.kevine.quelle.model.PostData
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayPosts()

    }



    fun displayPosts(){
        val retrofit = ApiClient.buildClient(ApiInterface::class.java)
        val request = retrofit.getPosts()
        request.enqueue(object: retrofit2.Callback<List<PostData>>{
            override fun onResponse(call: Call<List<PostData>>, response:
            Response<List<PostData>>
            ) {
                if (response.isSuccessful){
                    var posts = response.body()
                    Toast.makeText(baseContext, "${posts!!.size} posts", Toast.
                    LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<List<PostData>>, t: Throwable) {
            }
        })

        binding.rvposts.layoutManager=LinearLayoutManager(this)

    }


    }

