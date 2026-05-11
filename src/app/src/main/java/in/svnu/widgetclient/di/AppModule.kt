package `in`.svnu.widgetclient.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Hilt module for app-wide singletons.
 *
 * Provides: TokenManager, DataStore, WebSocketManager, etc.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // TODO: Phase 2 — Provide TokenManager, DataStore preferences
    // TODO: Phase 4 — Provide WebSocketManager
}
