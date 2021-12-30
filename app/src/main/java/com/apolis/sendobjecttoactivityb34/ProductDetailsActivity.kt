package com.apolis.sendobjecttoactivityb34

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val selectProduct: Product = intent.extras?.getSerializable("productInfo") as Product

        tvProductName.text = selectProduct.pName
        tvCategory.text = selectProduct.category
        tvPrice.text = "Price: \$ ${selectProduct.price}"
        rbRating.rating = selectProduct.userRating
    }
}