package `in`.svnu.widgetclient.domain.model

/**
 * Domain model representing a user in the system.
 */
data class User(
    val id: String,
    val email: String,
    val name: String,
)
