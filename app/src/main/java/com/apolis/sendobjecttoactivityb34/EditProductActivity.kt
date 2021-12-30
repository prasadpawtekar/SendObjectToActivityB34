package com.apolis.sendobjecttoactivityb34

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_product.btnSave
import kotlinx.android.synthetic.main.activity_edit_product.etCategory
import kotlinx.android.synthetic.main.activity_edit_product.etPrice
import kotlinx.android.synthetic.main.activity_edit_product.etProductName
import kotlinx.android.synthetic.main.activity_edit_product.rbRating

class EditProductActivity : AppCompatActivity() {
    var position: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_product)

        val product = intent.extras?.getSerializable("product") as Product
        position = intent.extras?.getInt("position")?: -1

        etProductName.setText(product.pName)
        etCategory.setText(product.category)
        etPrice.setText("${product.price}")
        rbRating.rating = product.userRating

        btnSave.setOnClickListener {
            val pName = etProductName.text.toString()
            val category = etCategory.text.toString()
            val price = etPrice.text.toString().toFloat()
            val userRating = rbRating.rating

            val editedProduct = Product(pName, category, price, userRating)

            val dataIntent = Intent()

            dataIntent.putExtra("editedProduct", editedProduct)
            dataIntent.putExtra("position", position)
            setResult(RESULT_OK, dataIntent)

            finish()
        }
    }
}