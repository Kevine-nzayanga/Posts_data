package com.kevine.quelle.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kevine.quelle.PostsrvAdapter
import com.kevine.quelle.R
import com.kevine.quelle.api.ApiClient
import com.kevine.quelle.api.ApiInterface
import com.kevine.quelle.databinding.ActivityMainBinding
import com.kevine.quelle.model.PostData
import com.kevine.quelle.viewModel.PostsViewModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val postsViewModel:PostsViewModel by viewModels()
    lateinit var postsAdapter:PostsrvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        postsViewModel.fetchPosts()
        postsViewModel.postsLiveData.observe(
            this,
            Observer { postsList ->
            val postsAdapter = PostsrvAdapter(postsList?: emptyList())
            binding.rvposts.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvposts.adapter=postsAdapter
            })
        postsViewModel.errorLiveData.observe(this, Observer{ error ->
            Toast.makeText( baseContext, error, Toast.LENGTH_LONG).show()
        })


    }




    }

