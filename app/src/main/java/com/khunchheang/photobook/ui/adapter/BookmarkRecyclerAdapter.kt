package com.khunchheang.photobook.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.khunchheang.photobook.R
import com.khunchheang.photobook.data.local.BookmarkRoomModel
import com.khunchheang.photobook.ui.base.adapter.BaseRecyclerAdapter
import kotlinx.android.synthetic.main.item_photo.view.*

class BookmarkRecyclerAdapter : BaseRecyclerAdapter<BookmarkRoomModel, BookmarkRecyclerAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun setViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (context == null) context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindData(holder: ViewHolder, data: BookmarkRoomModel, position: Int) {
        Glide.with(context!!)
            .load(data.listUrl)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .into(holder.itemView.img_photo)

        holder.itemView.img_photo.transitionName = "transition$position"
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { itemClicked?.invoke(itemView.img_photo, adapterPosition) }

            itemView.img_bookmark.setOnClickListener { itemClicked?.invoke(it, adapterPosition) }
        }
    }
}