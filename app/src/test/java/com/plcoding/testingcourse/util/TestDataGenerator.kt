package com.plcoding.testingcourse.util

import com.plcoding.testingcourse.part7.domain.Post
import com.plcoding.testingcourse.part7.domain.Profile
import com.plcoding.testingcourse.part7.domain.User
import java.util.UUID


fun profile(): Profile {
    val user = user()
    return Profile(
        user = user,
        posts = (1..10).map {
            post(userId = user.id)
        }
    )
}

fun post(
    userId: String
): Post {
    return Post(
        id = UUID.randomUUID().toString(),
        userId = userId,
        title = "test-title",
        body = "test-body"
    )
}

fun user(): User {
    return User(
        id = UUID.randomUUID().toString(),
        username = "test-user"
    )
}
