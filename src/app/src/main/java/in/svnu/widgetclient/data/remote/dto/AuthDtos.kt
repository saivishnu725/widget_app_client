package `in`.svnu.widgetclient.data.remote.dto

import com.google.gson.annotations.SerializedName

// ── Request DTOs ──

data class LoginRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
)

data class RegisterRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("name") val name: String,
)

// ── Response DTOs ──

data class AuthResponse(
    @SerializedName("token") val token: String,
    @SerializedName("user") val user: UserDto,
)

data class UserDto(
    @SerializedName("id") val id: String,
    @SerializedName("email") val email: String,
    @SerializedName("name") val name: String,
)

// ── Error DTO ──

data class ApiError(
    @SerializedName("error") val error: String?,
    @SerializedName("message") val message: String?,
)
