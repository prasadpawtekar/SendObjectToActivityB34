package com.apolis.sendobjecttoactivityb34

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ProductAdapter(val mContext: Context, val products: ArrayList<Product>): BaseAdapter() {

    private lateinit var editClickListener: (Product, Int) -> Unit

    fun setOnEditClickListener(listener: (Product, Int) -> Unit) {
        this.editClickListener = listener
    }


    override fun getCount() = products.size

    override fun getItem(position: Int) = products[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        if(convertView == null) {
            val layoutInflater = LayoutInflater.from(mContext)
            val view = layoutInflater.inflate(R.layout.item_product, null)

            val tvProductName: TextView = view.findViewById(R.id.tvProductName)
            val tvPrice: TextView = view.findViewById(R.id.tvPrice)
            val p = products[position]

            val ivEdit: ImageView = view.findViewById(R.id.ivEdit)

            ivEdit.setOnClickListener {
                if(this::editClickListener.isInitialized) {
                    editClickListener(p, position)
                }
            }
            tvPrice.text="\$${p.price}"
            tvProductName.text = p.pName
            return view
        } else {
            val tvProductName: TextView = convertView.findViewById(R.id.tvProductName)
            val tvPrice: TextView = convertView.findViewById(R.id.tvPrice)

            val p = products[position]
            tvPrice.text="\$${p.price}"
            tvProductName.text = p.pName

            val ivEdit: ImageView = convertView.findViewById(R.id.ivEdit)

            ivEdit.setOnClickListener {
                if(this::editClickListener.isInitialized) {
                    editClickListener(p, position)
                }
            }
            return convertView
        }
    }
}