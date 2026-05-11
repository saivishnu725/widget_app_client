package `in`.svnu.widgetclient.util

/**
 * Kotlin extension functions used throughout the app.
 */

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

/**
 * Show a short toast message.
 */
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * Catch and handle exceptions in a Flow, emitting an error Resource.
 */
fun <T> Flow<T>.handleErrors(): Flow<T> =
    catch { e ->
        // Log or handle the error
        throw e
    }
