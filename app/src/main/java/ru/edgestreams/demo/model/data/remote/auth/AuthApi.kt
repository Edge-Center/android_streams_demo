package ru.edgestreams.demo.model.data.remote.auth

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("./iam/auth/jwt/login")
    fun performLogin(@Body body: AuthRequestBody): Single<AuthResponse>
}