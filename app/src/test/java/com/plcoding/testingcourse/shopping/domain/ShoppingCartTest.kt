package com.plcoding.testingcourse.shopping.domain

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

internal class ShoppingCartTest {

    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setup() {
        cart = ShoppingCart()
    }

    @Test
    fun `Add multiple products, total price sum is correct`() {
        // GIVEN
        val product = Product(
            id = 0,
            name = "Book",
            price = 10.0
        )
        cart.addProduct(product, 4)

        // ACTION
        val priceSum = cart.getTotalCost()

        // ASSERTION
        assertThat(priceSum).isEqualTo(40.0)
    }

    @RepeatedTest(10) // Repeat test 10 times and only is in JUnit 5
    fun `Add product with negative quantity, throw exception`() {
        val product = Product(
            id = 0,
            name = "Book",
            price = 10.0
        )
        assertFailure {
            cart.addProduct(product, -5)
        }
    }
}