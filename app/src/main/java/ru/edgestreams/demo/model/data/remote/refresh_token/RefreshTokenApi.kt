package ru.edgestreams.demo.model.data.remote.refresh_token

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import ru.edgestreams.demo.model.data.remote.auth.AuthResponse

interface RefreshTokenApi {
    @POST("./iam/auth/jwt/refresh")
    fun refreshToken(@Body body: RefreshRequestBody): Single<AuthResponse>
}