package `in`.svnu.widgetclient.domain.model

/**
 * Domain model representing the real-time state of a widget.
 */
data class WidgetState(
    val widgetId: String,
    val state: ToggleState = ToggleState.OFF,
    val lastModifiedBy: String? = null,
    val lastModifiedAt: Long = 0L,
    val activeUsers: List<String> = emptyList(),
)

/**
 * Represents the toggle state of a widget.
 */
enum class ToggleState {
    ON,
    OFF;

    companion object {
        fun fromString(value: String): ToggleState =
            when (value.uppercase()) {
                "ON" -> ON
                "OFF" -> OFF
                else -> OFF
            }
    }
}
