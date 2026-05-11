package `in`.svnu.widgetclient.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Hilt module providing database-related dependencies.
 *
 * Provides: AppDatabase, WidgetDao, WidgetStateDao, SyncQueueDao
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    // TODO: Phase 3 — Provide Room database and DAOs
}
