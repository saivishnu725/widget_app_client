package `in`.svnu.widgetclient.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import `in`.svnu.widgetclient.util.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages JWT token storage using EncryptedSharedPreferences.
 *
 * Uses Android Keystore-backed encryption so the token is secure at rest.
 * Provides synchronous access since interceptors run on OkHttp's thread pool.
 */
@Singleton
class TokenManager @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private val prefs: SharedPreferences by lazy {
        EncryptedSharedPreferences.create(
            Constants.ENCRYPTED_PREFS_NAME,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
        )
    }

    fun saveToken(token: String) {
        prefs.edit().putString(Constants.KEY_JWT_TOKEN, token).apply()
    }

    fun getToken(): String? {
        return prefs.getString(Constants.KEY_JWT_TOKEN, null)
    }

    fun clearToken() {
        prefs.edit().remove(Constants.KEY_JWT_TOKEN).apply()
    }

    fun hasToken(): Boolean {
        return getToken() != null
    }
}
