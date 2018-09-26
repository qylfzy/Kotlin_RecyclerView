package com.qiyou.kotlin_1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_rv_test.view.*

class RvAdpter(var list: MutableList<String>, var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onClick: OnItemClickListener? = null

    fun setOnItemClick(onItemClickListener: OnItemClickListener) {
        this.onClick = onItemClickListener
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_rv_test, p0, false)
        val holder = Holder(itemView)
        itemView.setOnClickListener {
            onClick!!.OnItemClick(itemView, itemView.tag as Int)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        viewHolder.itemView.tv_title.text = list[position]
        viewHolder.itemView.tag = position
        when (position % 2) {
            0 -> viewHolder.itemView.setBackgroundColor(context.resources.getColor(R.color.colorAccent))
            else -> viewHolder.itemView.setBackgroundColor(context.resources.getColor(R.color.colorPrimaryDark))
        }
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnItemClickListener {
        fun OnItemClick(view: View, position: Int)
    }

}