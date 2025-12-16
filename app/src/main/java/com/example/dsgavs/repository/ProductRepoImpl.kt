package com.example.dsgavs.repository

import com.example.dsgavs.model.ProductModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class ProductRepoImpl: ProductRepo {

    val database = Firebase.database

    val ref: DatabaseReference = database.getReference("Products")


    override fun addProduct(
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {
        val id = ref.push().key.toString()
        model.productId = id

        ref.child(id).setValue(model).addOnCompleteListener {
            if (it.isSuccessful) {
                callback(true, "Product added successfully")
            } else {
                callback(false, "${it.exception?.message}")
            }
        }
    }

    override fun getAllProducts(
        callback: (Boolean, String, List<ProductModel>) -> Unit) {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val allProducts = mutableListOf<ProductModel>()
                    for (data in snapshot.children) {
                        val product = data.getValue(ProductModel::class.java)
                        if (product != null) {
                            allProducts.add(product)
                        }}
                    callback(true, "Products fetched successfully", allProducts)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                callback(false, error.message, emptyList())
            }
        })
    }

    override fun getProductById(
        productId: String,
        callback: (Boolean, String, ProductModel?) -> Unit
    ) {
        ref.child(productId).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var data = snapshot.getValue(ProductModel::class.java)
                    if (data != null) {
                        callback(true, "Product fetched successfully", data)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                callback(false, error.message, null)
            }
        })
    }

    override fun updateProduct(
        productId: String,
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(productId).updateChildren(model.toMap())
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback(true, "Product updated successfully")
                } else {
                    callback(false, "${it.exception?.message}")
                }
            }
    }

    override fun deleteProduct(
        productId: String,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(productId).removeValue().addOnCompleteListener {
            if (it.isSuccessful) {
                callback(true, "Product deleted successfully")
            } else {
                callback(false, "${it.exception?.message}")
            }
        }
    }

    override fun getProductsByCategory(
        categoryId: String,
        callback: (Boolean, String, List<ProductModel>) -> Unit
    ) {

    }
}