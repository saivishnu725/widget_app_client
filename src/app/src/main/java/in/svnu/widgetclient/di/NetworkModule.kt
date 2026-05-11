package `in`.svnu.widgetclient.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Hilt module providing network-related dependencies.
 *
 * Provides: OkHttpClient, Retrofit instance, AuthApi, WidgetApi
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    // TODO: Phase 2 — Provide OkHttpClient, Retrofit, AuthApi, WidgetApi
}
