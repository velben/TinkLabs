package com.ouweibin.interview.features.main.adapter

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ouweibin.interview.R
import com.ouweibin.interview.core.extension.*
import com.ouweibin.interview.features.main.bean.CityGuide

class CityGuideAdapter(var list: MutableList<CityGuide> = mutableListOf()) : RecyclerView.Adapter<CityGuideAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_city_guide))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(list[position]) {
            if (!TextUtils.isEmpty(imgUrl)) {
                if ((!TextUtils.isEmpty(title) || !TextUtils.isEmpty(description))) {
                    holder.ivFullImage.invisible()
                    holder.ivLeft.visible()
                    holder.tvTitle.visible()
                    holder.tvDescription.visible()
                    // 加载图片
//                    holder.ivLeft.loadFromUrl(imgUrl!!)
//                    holder.tvTitle.text = title ?: String.empty()
//                    holder.tvDescription.text = description ?: String.empty()
                } else {
                    holder.ivFullImage.visible()
                    holder.ivLeft.invisible()
                    holder.tvTitle.invisible()
                    holder.tvDescription.invisible()
                    // 加载图片
//                    holder.ivFullImage.loadFromUrl(imgUrl!!)
                }
            }
        }

    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<CityGuide>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    fun addData(newList: List<CityGuide>) {
        list.addAll(newList)
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivLeft: ImageView = view.findViewById(R.id.ivLeft)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvDescription: TextView = view.findViewById(R.id.tvDescription)
        val ivFullImage: ImageView = view.findViewById(R.id.ivFullImage)
    }
}