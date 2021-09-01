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

    class CapitalViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvId: AppCompatTextView = view.findViewById(R.id.idPost)
        val tvTitle: AppCompatTextView = view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapitalViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post_layout, parent, false)
        return CapitalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CapitalViewHolder) {
            val item = mDataList[position]
            holder.tvId.text = item.id.toString()
            holder.tvTitle.text = item.title
        }
    }

}