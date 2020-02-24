package com.codingwithset.fixaslabtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingwithset.fixaslabtask.DataAdapter.DealAdapterViewHolder

class DataAdapter(
    private val mContext: Context,
    productList: List<Data>
) : RecyclerView.Adapter<DealAdapterViewHolder>() {
    private val mProductList: List<Data>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DealAdapterViewHolder {
        val view: View =
            LayoutInflater.from(mContext).inflate(R.layout.data_items, parent, false)
        return DealAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: DealAdapterViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return mProductList.size
    }

    inner class DealAdapterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {


    }

    init {
        mProductList = productList
    }
}