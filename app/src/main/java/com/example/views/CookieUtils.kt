package com.example.views

import android.os.Build
import android.webkit.CookieManager

object CookieUtils {
    @Suppress("Deprecation")
    fun clearCookies() {
        try {
            CookieManager.getInstance().removeAllCookies(null)
            CookieManager.getInstance().flush()
        } catch (e: Exception) {
        }
    }
}
