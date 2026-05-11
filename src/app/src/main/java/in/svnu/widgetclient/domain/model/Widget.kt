package `in`.svnu.widgetclient.domain.model

/**
 * Domain model representing a widget.
 *
 * This is the clean domain representation decoupled from the
 * data layer entities (Room) and network DTOs (Retrofit).
 */
data class Widget(
    val id: String,
    val name: String,
    val emoji: String,
    val ownerId: String,
    val sharedUserIds: List<String> = emptyList(),
    val isOverlayActive: Boolean = true,
    val overlayPositionX: Float = 0f,
    val overlayPositionY: Float = 0f,
    val createdAt: Long = 0L,
    val updatedAt: Long = 0L,
)
