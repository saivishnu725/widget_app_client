package `in`.svnu.widgetclient.data.remote

/**
 * Manages the Socket.io client connection for real-time widget state updates.
 *
 * Responsibilities:
 * - Connect/disconnect with JWT auth
 * - Auto-reconnect with exponential backoff
 * - Emit: subscribe_widgets, toggle_widget
 * - Listen: state_changed, toggle_error
 * - Expose connection state as StateFlow
 */
// TODO: Phase 4 — Implement WebSocketManager as @Singleton
