
package com.colamarino.yazioapp.data.repository

import android.content.Context
import com.colamarino.yazioapp.data.local.TokenStore
import com.colamarino.yazioapp.data.remote.YazioApi
import com.colamarino.yazioapp.data.remote.models.TokenResponse

class YazioRepository(context: Context){
    private val api: YazioApi = YazioApi.create()
    private val store = TokenStore(context)

    // in-memory cache
    private var accessToken: String? = null

    suspend fun login(email:String, password:String): Boolean {
        val resp: TokenResponse = api.login(email = email, password = password)
        accessToken = resp.access_token
        store.save(resp.access_token, resp.refresh_token)
        return accessToken != null
    }

    suspend fun macros(from:String, to:String): Map<String,Any> {
        val t = accessToken ?: ""
        return api.macros("Bearer $t", from, to)
    }
}
