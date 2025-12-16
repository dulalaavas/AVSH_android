package com.example.dsgavs.model

class ProductModel(
    var productId: String = "",
    var name: String = "",
    var description: String = "",
    var price: Double = 0.0,
    var categoryId: String = ""
) {
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "name" to name,
            "description" to description,
            "price" to price,
            "categoryId" to categoryId
        )
    }
}