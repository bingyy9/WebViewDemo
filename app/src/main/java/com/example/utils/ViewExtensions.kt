package com.example.utils

import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

@SuppressLint("JavascriptInterface", "SetJavaScriptEnabled")
fun WebView.initialize(webClient: WebViewClient, name: String) {
    clearCache(true)
    addJavascriptInterface(webClient, name)
    webViewClient = webClient
    settings.setSupportZoom(true)
    settings.javaScriptEnabled = true
    settings.domStorageEnabled = true
    settings.allowFileAccess = false
    settings.cacheMode = WebSettings.LOAD_NO_CACHE
}