package com.onsenstamprallyapp.ui.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.log.LogTag
import com.onsenstamprallyapp.log.LogWrapper
import com.onsenstamprallyapp.model.OnsenInfo

internal class OnsenListAdapter(
    private val onItemClick: (OnsenInfo) -> Unit
) : ListAdapter<OnsenInfo, OnsenListAdapter.VH>(ITEM_CALLBACK) {

    private val logTag by LogTag()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.onsen_list_item, parent, false)
        return VH(item)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        LogWrapper.print(logTag, "onBindViewHolder")
        holder.bind(getItem(position))
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(info: OnsenInfo) {
            val titleView = itemView.findViewById<TextView>(R.id.title)
            titleView.text = info.name
            val subtitle = itemView.findViewById<TextView>(R.id.subtitle)
            subtitle.text = info.address

            val stampImage = itemView.findViewById<ImageView>(R.id.stampImage)
            stampImage.isVisible = info.isStamped

            itemView.rootView.setOnClickListener {
                onItemClick(info)
            }
        }
    }
}

private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<OnsenInfo>() {
    override fun areItemsTheSame(oldItem: OnsenInfo, newItem: OnsenInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: OnsenInfo, newItem: OnsenInfo): Boolean {
        return oldItem == newItem
    }
}