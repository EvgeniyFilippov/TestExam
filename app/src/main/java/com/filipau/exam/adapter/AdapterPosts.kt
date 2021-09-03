package com.filipau.exam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.filipau.domain.dto.post.PostItemDto
import com.filipau.exam.R
import com.filipau.exam.base.adapter.BaseAdapter

class AdapterPosts : BaseAdapter<PostItemDto>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvId: AppCompatTextView = view.findViewById(R.id.idPost)
        val tvTitle: AppCompatTextView = view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post_layout, parent, false)

        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PostViewHolder) {
            val item = mDataList[position]
            holder.tvId.text = item.id.toString()
            holder.tvTitle.text = item.title
            holder.itemView.setOnClickListener { mClickFunction?.invoke(item) }
        }
    }

}