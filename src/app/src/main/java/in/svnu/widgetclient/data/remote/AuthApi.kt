package `in`.svnu.widgetclient.data.remote

import `in`.svnu.widgetclient.data.remote.dto.AuthResponse
import `in`.svnu.widgetclient.data.remote.dto.LoginRequest
import `in`.svnu.widgetclient.data.remote.dto.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Retrofit API interface for authentication endpoints.
 *
 * These endpoints do NOT require JWT — they are public.
 */
interface AuthApi {

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>
}
