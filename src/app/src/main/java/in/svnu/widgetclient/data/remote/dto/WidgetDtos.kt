package `in`.svnu.widgetclient.data.remote.dto

import com.google.gson.annotations.SerializedName

// ── Request DTOs ──

data class CreateWidgetRequest(
    @SerializedName("name") val name: String,
    @SerializedName("emoji") val emoji: String,
)

data class UpdateWidgetRequest(
    @SerializedName("name") val name: String? = null,
    @SerializedName("emoji") val emoji: String? = null,
)

data class ShareWidgetRequest(
    @SerializedName("action") val action: String, // "add" or "remove"
    @SerializedName("targetUserId") val targetUserId: String,
)

// ── Response DTOs ──

data class WidgetsResponse(
    @SerializedName("widgets") val widgets: List<WidgetDto>,
)

data class WidgetResponse(
    @SerializedName("widget") val widget: WidgetDto,
)

data class WidgetDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("emoji") val emoji: String,
    @SerializedName("ownerId") val ownerId: String,
    @SerializedName("sharedWith") val sharedWith: List<SharedUserDto>? = null,
    @SerializedName("createdAt") val createdAt: String? = null,
    @SerializedName("updatedAt") val updatedAt: String? = null,
)

data class SharedUserDto(
    @SerializedName("id") val id: String,
    @SerializedName("email") val email: String? = null,
    @SerializedName("name") val name: String? = null,
)

data class WidgetStateResponse(
    @SerializedName("widgetId") val widgetId: String,
    @SerializedName("state") val state: String, // "ON" or "OFF"
    @SerializedName("lastModifiedBy") val lastModifiedBy: String? = null,
    @SerializedName("lastModifiedAt") val lastModifiedAt: String? = null,
    @SerializedName("activeUsers") val activeUsers: List<String> = emptyList(),
)
