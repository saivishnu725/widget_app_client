package `in`.svnu.widgetclient.util

/**
 * App-wide constants.
 */
object Constants {
    // DataStore
    const val USER_PREFERENCES = "user_preferences"
    const val ENCRYPTED_PREFS_NAME = "secure_prefs"

    // Token
    const val KEY_JWT_TOKEN = "jwt_token"
    const val KEY_USER_ID = "user_id"
    const val KEY_USER_EMAIL = "user_email"
    const val KEY_USER_NAME = "user_name"

    // WebSocket events
    const val EVENT_SUBSCRIBE_WIDGETS = "subscribe_widgets"
    const val EVENT_TOGGLE_WIDGET = "toggle_widget"
    const val EVENT_STATE_CHANGED = "state_changed"
    const val EVENT_TOGGLE_ERROR = "toggle_error"

    // Widget states
    const val STATE_ON = "ON"
    const val STATE_OFF = "OFF"

    // Sync queue
    const val MAX_SYNC_ATTEMPTS = 3
    const val MAX_QUEUE_SIZE = 50

    // Reconnection
    const val RECONNECTION_DELAY_MS = 1000L
    const val RECONNECTION_DELAY_MAX_MS = 30000L

    // Periodic sync interval
    const val FULL_SYNC_INTERVAL_MS = 30 * 60 * 1000L  // 30 minutes

    // Rate limiting
    const val TOGGLE_DEBOUNCE_MS = 300L
}
