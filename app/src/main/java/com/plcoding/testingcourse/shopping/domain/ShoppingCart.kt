package com.plcoding.testingcourse.shopping.domain


class ShoppingCart {
    private val validProductIds = listOf(1, 2, 3, 4, 5)
    private val items = mutableListOf<Product>()

    fun addProduct(product: Product, quantity: Int) {
        if (quantity < 0) {
            throw IllegalArgumentException("Quantity can't be negative")
        }
        if (isValidProductId(product)) {
            repeat(quantity) {
                items.add(product)
            }
        }
    }

    private fun isValidProductId(product: Product): Boolean {
        return product.price >= 0.0 && product.id in validProductIds
    }

    fun getTotalCost(): Double {
        return items.sumOf { it.price }
    }
}