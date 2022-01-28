package com.onsenstamprallyapp.ui.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onsenstamprallyapp.R
import com.onsenstamprallyapp.domain.model.Goods
import com.onsenstamprallyapp.ui.widget.GoodsListAdapter.VH

internal class GoodsListAdapter() : ListAdapter<Goods, VH>(ITEM_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.goods_list_item, parent, false)
        return VH(item)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }


    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(goods: Goods) {
            val titleView = itemView.findViewById<TextView>(R.id.title)
            titleView.text = goods.title
            val subtitle = itemView.findViewById<TextView>(R.id.subtitle)
            subtitle.text = goods.description

            val subtitle2 = itemView.findViewById<TextView>(R.id.subtitle2)
            subtitle2.text = itemView.context.getString(R.string.stamp_count_desc, goods.stamps)
        }
    }
}

private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<Goods>() {
    override fun areItemsTheSame(oldItem: Goods, newItem: Goods): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Goods, newItem: Goods): Boolean {
        return oldItem == newItem
    }
}