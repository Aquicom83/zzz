
package com.colamarino.yazioapp.data.remote

import com.colamarino.yazioapp.BuildConfig
import com.colamarino.yazioapp.data.remote.models.TokenResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface YazioApi {
    @FormUrlEncoded
    @POST("oauth/token")
    suspend fun login(
        @Field("grant_type") grantType: String = "password",
        @Field("username") email: String,
        @Field("password") password: String,
        @Field("client_id") clientId: String = BuildConfig.YAZIO_CLIENT_ID,
        @Field("client_secret") clientSecret: String = BuildConfig.YAZIO_CLIENT_SECRET
    ): TokenResponse

    @GET("v5/user/data")
    suspend fun userData(@Header("Authorization") bearer: String): Map<String, Any>

    @GET("v5/intake/macros")
    suspend fun macros(
        @Header("Authorization") bearer: String,
        @Query("from") from: String,
        @Query("to") to: String
    ): Map<String, Any>

    @GET("v5/intake/{kind}")
    suspend fun intake(
        @Header("Authorization") bearer: String,
        @Path("kind") kind: String,
        @Query("from") from: String,
        @Query("to") to: String
    ): Map<String, Any>

    companion object {
        fun create(): YazioApi {
            val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            val client = OkHttpClient.Builder().addInterceptor(logging).build()
            return Retrofit.Builder()
                .baseUrl(BuildConfig.YAZIO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(YazioApi::class.java)
        }
    }
}
