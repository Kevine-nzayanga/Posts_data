package com.kevine.quelle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kevine.quelle.databinding.PostsBinding
import com.kevine.quelle.model.PostData

class PostsrvAdapter(var postsList: List<PostData>): RecyclerView.Adapter<PostsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var binding = PostsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return postsList.size

    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var currentpost=postsList[position]

        holder.binding.apply {
            tvtitle.text=currentpost.title
            tvbody.text=currentpost.body

        }
    }
    }


class PostsViewHolder(var binding:PostsBinding):RecyclerView.ViewHolder(binding.root){

}



































