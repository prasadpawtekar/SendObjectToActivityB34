package com.apolis.sendobjecttoactivityb34

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_product.*

class AddProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)



        btnSave.setOnClickListener {
            val pName = etProductName.text.toString()
            val category = etCategory.text.toString()
            val price = etPrice.text.toString().toFloat()
            val userRating = rbRating.rating

            val newProduct = Product(pName, category, price, userRating)

            val dataIntent = Intent()

            dataIntent.putExtra("newProduct", newProduct)

            setResult(RESULT_OK, dataIntent)

            finish()

        }
    }
}