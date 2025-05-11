package com.doan.mechacal.api

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object TokenManager {
    private const val PREF_NAME = "auth_prefs"
    private const val ACCESS_TOKEN_KEY = "access_token"
    private const val REFRESH_TOKEN_KEY = "refresh_token"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun saveTokens(context: Context, accessToken: String, refreshToken: String) {
        val prefs = getPreferences(context)
        prefs.edit().apply {
            putString(ACCESS_TOKEN_KEY, accessToken)
            putString(REFRESH_TOKEN_KEY, refreshToken)
            apply()
        }
    }

    fun getAccessToken(context: Context): String? {
        return getPreferences(context).getString(ACCESS_TOKEN_KEY, null)
    }

    fun getRefreshToken(context: Context): String? {
        return getPreferences(context).getString(REFRESH_TOKEN_KEY, null)
    }

    fun clearTokens(context: Context) {
        getPreferences(context).edit() { clear() }
    }
}
