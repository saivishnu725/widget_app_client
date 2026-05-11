package `in`.svnu.widgetclient.data.remote

/**
 * Retrofit API interface for widget CRUD and state endpoints.
 *
 * Server endpoints:
 * - GET    /api/widgets           → { widgets: [...] }
 * - POST   /api/widgets           → { widget }
 * - PUT    /api/widgets/:id       → { widget }
 * - DELETE /api/widgets/:id       → 204
 * - PUT    /api/widgets/:id/share → { widget }
 * - GET    /api/widgets/:id/state → { widgetId, state, lastModifiedBy, lastModifiedAt, activeUsers }
 */
// TODO: Phase 2 — Implement WidgetApi interface with Retrofit annotations
