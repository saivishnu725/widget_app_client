package `in`.svnu.widgetclient

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class for the Widget Client app.
 * @HiltAndroidApp triggers Hilt's code generation and serves as
 * the application-level dependency container.
 */
@HiltAndroidApp
class WidgetClientApp : Application()
