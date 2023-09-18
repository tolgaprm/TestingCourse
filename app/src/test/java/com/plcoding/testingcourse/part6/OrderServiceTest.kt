package com.plcoding.testingcourse.part6

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderServiceTest {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailClient: EmailClient
    private lateinit var orderService: OrderService

    @BeforeEach
    fun setUp() {
        val firebaseUser = mockk<FirebaseUser>(relaxed = true) {
            every { isAnonymous } returns false
        }
        auth = mockk(relaxed = true) {
            every { currentUser } returns firebaseUser
        }
        emailClient = mockk(relaxed = true)
        orderService = OrderService(auth = auth, emailClient = emailClient)
    }

    @Test
    fun `test placeOrder, when currentUser is not anonymous, send correct email and productName`() {
        val customerEmail = "test@gmail.com"
        val productName = "Game Mouse"
        orderService.placeOrder(customerEmail = customerEmail, productName = productName)
        verify {
            emailClient.send(
                Email(
                    subject = "Order Confirmation",
                    content = "Thank you for your order of Game Mouse.",
                    recipient = customerEmail
                )
            )
        }
    }
}