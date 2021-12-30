package com.apolis.sendobjecttoactivityb34

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val products = ArrayList<Product>()

    init {
        products.add(Product("iPhone 12 Pro", "Mobile", 1000f, 4.9f ))
        products.add(Product("iPhone 13 Pro", "Mobile", 1200f, 4.8f ))
        products.add(Product("Dell Inspiron 5570", "Laptop", 800f, 4.3f ))
        products.add(Product("Realme 5 Pro", "Mobile", 300f, 4.5f ))
        products.add(Product("iBall Wireless Keyboard", "Accessories", 50f, 3.5f ))
        products.add(Product("Samsung S20 Note", "Mobile", 800f, 4.2f ))

    }

    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ProductAdapter(this, products)
        lvProducts.adapter = adapter


        adapter.setOnEditClickListener { product, position ->
            val editIntent = Intent(baseContext, EditProductActivity::class.java)

            editIntent.putExtra("product", product)
            editIntent.putExtra("position", position)

            startActivityForResult(editIntent, EDIT_PRODUCT_REQUEST)
        }

        lvProducts.setOnItemClickListener { parent, view, position, id ->
            val product = products[position]
            val pIntent = Intent(baseContext, ProductDetailsActivity::class.java)
            pIntent.putExtra("productInfo", product)
            startActivity(pIntent)

        }

        btnAddProduct.setOnClickListener {
            val addProductIntent = Intent(baseContext, AddProductActivity::class.java)
            startActivityForResult(addProductIntent, ADD_PRODUCT_REQUEST)
        }
    }

    companion object {
        const val ADD_PRODUCT_REQUEST = 100
        const val EDIT_PRODUCT_REQUEST = 200
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK) {
            when(requestCode) {
                ADD_PRODUCT_REQUEST -> {
                    val product = data?.extras?.getSerializable("newProduct") as Product
                    products.add(product)
                    adapter.notifyDataSetChanged()
                }

                EDIT_PRODUCT_REQUEST -> {
                    val editedProduct = data?.extras?.getSerializable("editedProduct") as Product
                    val position = data?.extras?.getInt("position")?: -1
                    if(position != -1) {
                        products[position] = editedProduct
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }
}