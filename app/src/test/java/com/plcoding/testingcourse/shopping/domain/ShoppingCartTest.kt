package com.plcoding.testingcourse.shopping.domain

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ShoppingCartTest {

    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setup() {
        cart = ShoppingCart()
    }

    @ParameterizedTest
    @CsvSource(
        "0, 0.0",
        "1, 10.0",
        "2, 20.0",
        "5, 50.0",
        "10, 100.0",
        "100, 1000.0"
    )
    fun `Add multiple products, total price sum is correct`(
        quantity: Int,
        expectedPriceSum: Double
    ) {
        // GIVEN
        val product = Product(
            id = 0,
            name = "Book",
            price = 10.0
        )
        cart.addProduct(product, quantity)

        // ACTION
        val priceSum = cart.getTotalCost()

        // ASSERTION
        assertThat(priceSum).isEqualTo(expectedPriceSum)
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