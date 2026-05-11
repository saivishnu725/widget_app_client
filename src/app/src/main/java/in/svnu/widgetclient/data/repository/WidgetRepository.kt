package `in`.svnu.widgetclient.data.repository

/**
 * Single-source-of-truth repository for widgets.
 *
 * Fetches from REST API, caches to Room, exposes Flow<List<Widget>>
 * for reactive UI observation. CRUD operations hit API first,
 * then update Room on success.
 */
// TODO: Phase 3 — Implement WidgetRepository
