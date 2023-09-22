package com.example.meetingcontainerdemo2;

import android.app.Application
import android.content.Context
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptor
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptorInst
import kotlin.coroutines.CoroutineContext


class MyApplication: Application(), CoroutineScope {
    override val coroutineContext: CoroutineContext
    get() = Dispatchers.Default

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "onCreate")
        instance = this
        WebViewCacheInterceptorInst.getInstance().init(WebViewCacheInterceptor.Builder(this))

    }

    companion object {
        const val TAG = "MyApplication"

        lateinit var instance: MyApplication
            private set

        fun applicationContext(): Context {
            return instance.applicationContext
        }

        fun get(): MyApplication {
            return instance
        }
    }
}
