package com.codingwithset.fixaslabtask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingwithset.fixaslabtask.R
import com.codingwithset.fixaslabtask.adapter.DataAdapter.DealAdapterViewHolder
import com.codingwithset.fixaslabtask.model.Data
import kotlinx.android.synthetic.main.data_items.view.*

class DataAdapter(
    private val mContext: Context,
    private val mProductList: List<Data>
) : RecyclerView.Adapter<DealAdapterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DealAdapterViewHolder {
        val view: View =
            LayoutInflater.from(mContext).inflate(R.layout.data_items, parent, false)
        return DealAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: DealAdapterViewHolder, position: Int) {
        holder.name.text = mProductList[position].name
        holder.priceUsd.text = mProductList[position].price_usd
        holder.percentageChange.text = mProductList[position].percent_change_1h
        holder.symbol.text = mProductList[position].symbol


    }

    override fun getItemCount(): Int {
        return mProductList.size
    }

    inner class DealAdapterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val name = itemView.name!!
        val priceUsd = itemView.price_usd!!
        val percentageChange = itemView.percent_change_1h!!
        val symbol = itemView.symbol!!


    }


}