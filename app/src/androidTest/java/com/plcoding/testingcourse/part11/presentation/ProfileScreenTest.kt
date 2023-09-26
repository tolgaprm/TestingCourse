package com.plcoding.testingcourse.part11.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.plcoding.testingcourse.ui.theme.TestingCourseTheme
import org.junit.Rule
import org.junit.Test

class ProfileScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testProfileScreen_profileLoaded() {
        composeTestRule.setContent {
            TestingCourseTheme {
                ProfileScreen(state = previewProfileState())
            }
        }

        composeTestRule.onNodeWithText("Test username").assertIsDisplayed()
        composeTestRule.onNodeWithText("Title1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Body1").assertIsDisplayed()

    }
}