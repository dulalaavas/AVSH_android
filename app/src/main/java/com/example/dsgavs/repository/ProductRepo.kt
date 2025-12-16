package com.example.dsgavs.repository

import com.example.dsgavs.model.ProductModel

interface ProductRepo {
    fun addProduct(
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    )

    fun getAllProducts(
        callback: (Boolean, String, List<ProductModel>) -> Unit
    )

    fun getProductById(
        productId: String,
        callback: (Boolean, String, ProductModel?) -> Unit
    )

    fun updateProduct(
        productId: String,
        model: ProductModel,
        callback: (Boolean, String) -> Unit
    )

    fun deleteProduct(
        productId: String,
        callback: (Boolean, String) -> Unit)

    fun getProductsByCategory(
        categoryId: String,
        callback: (Boolean, String, List<ProductModel>) -> Unit
    )
}