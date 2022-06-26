package com.example.app_catatan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    val hasil: ArrayList<Read.Data>,
    val listener: OnAdapterListener

):RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.main_adapter, parent, false)
    )

    override fun getItemCount():Int {
        return hasil.size
        //return body.size
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val data = hasil[position]

        holder.view.findViewById<TextView>(R.id.tv_judul).text = data.judul
        holder.view.findViewById<TextView>(R.id.tv_catatan).text = data.catatan
        holder.view.findViewById<TextView>(R.id.tv_tgl).text = data.tgl

        holder.view.findViewById<TextView>(R.id.btn_update).setOnClickListener{
            listener.onUpdate(data)
        }

        holder.view.findViewById<TextView>(R.id.btn_delete).setOnClickListener{
            listener.onDelete(data)
        }
    }
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    public fun setData(data: List<Read.Data>){
        hasil.clear()
        hasil.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun onUpdate(hasil: Read.Data)
        fun onDelete(hasil: Read.Data)
    }
}