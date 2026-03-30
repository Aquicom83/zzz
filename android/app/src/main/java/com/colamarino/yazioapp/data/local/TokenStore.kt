
package com.colamarino.yazioapp.data.local

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "yazio_prefs")

class TokenStore(private val context: Context) {
    private val KEY_ACCESS = stringPreferencesKey("access_token")
    private val KEY_REFRESH = stringPreferencesKey("refresh_token")

    val accessToken: Flow<String?> = context.dataStore.data.map { it[KEY_ACCESS] }
    val refreshToken: Flow<String?> = context.dataStore.data.map { it[KEY_REFRESH] }

    suspend fun save(access:String?, refresh:String?) {
        context.dataStore.edit { prefs: Preferences ->
            if (access!=null) prefs[KEY_ACCESS]=access else prefs.remove(KEY_ACCESS)
            if (refresh!=null) prefs[KEY_REFRESH]=refresh else prefs.remove(KEY_REFRESH)
        }
    }
}
