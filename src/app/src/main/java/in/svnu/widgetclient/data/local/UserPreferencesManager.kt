package `in`.svnu.widgetclient.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import `in`.svnu.widgetclient.domain.model.User
import `in`.svnu.widgetclient.util.Constants
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

// Extension property to create a single DataStore instance
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = Constants.USER_PREFERENCES
)

/**
 * Manages user preferences (non-secret data) via Jetpack DataStore.
 *
 * Stores user info (id, email, name) that's used throughout the app
 * for display and API call context. Not encrypted — these aren't secrets.
 */
@Singleton
class UserPreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    private object Keys {
        val USER_ID = stringPreferencesKey(Constants.KEY_USER_ID)
        val USER_EMAIL = stringPreferencesKey(Constants.KEY_USER_EMAIL)
        val USER_NAME = stringPreferencesKey(Constants.KEY_USER_NAME)
    }

    val userFlow: Flow<User?> = context.dataStore.data.map { prefs ->
        val id = prefs[Keys.USER_ID] ?: return@map null
        val email = prefs[Keys.USER_EMAIL] ?: return@map null
        val name = prefs[Keys.USER_NAME] ?: return@map null
        User(id = id, email = email, name = name)
    }

    suspend fun saveUser(user: User) {
        context.dataStore.edit { prefs ->
            prefs[Keys.USER_ID] = user.id
            prefs[Keys.USER_EMAIL] = user.email
            prefs[Keys.USER_NAME] = user.name
        }
    }

    suspend fun clearUser() {
        context.dataStore.edit { it.clear() }
    }

    suspend fun getUserId(): String? {
        var userId: String? = null
        context.dataStore.edit { prefs ->
            userId = prefs[Keys.USER_ID]
        }
        return userId
    }
}
