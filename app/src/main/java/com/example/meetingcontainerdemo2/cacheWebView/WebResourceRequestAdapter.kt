//package com.example.meetingcontainerdemo2.cacheWebView
//
//import android.annotation.TargetApi
//import android.net.Uri
//import android.os.Build
//import android.webkit.WebResourceRequest
//
//
///**
// * Created by yale on 2018/7/26.
// */
//@TargetApi(Build.VERSION_CODES.LOLLIPOP)
//class WebResourceRequestAdapter private constructor(x5Request: com.tencent.smtt.export.external.interfaces.WebResourceRequest) : WebResourceRequest {
//    private val mWebResourceRequest: com.tencent.smtt.export.external.interfaces.WebResourceRequest
//
//    init {
//        mWebResourceRequest = x5Request
//    }
//
//    override fun getUrl(): Uri {
//        return mWebResourceRequest.getUrl()
//    }
//
//    override fun isForMainFrame(): Boolean {
//        return mWebResourceRequest.isForMainFrame()
//    }
//
//    override fun isRedirect(): Boolean {
//        return mWebResourceRequest.isRedirect()
//    }
//
//    override fun hasGesture(): Boolean {
//        return mWebResourceRequest.hasGesture()
//    }
//
//    override fun getMethod(): String {
//        return mWebResourceRequest.getMethod()
//    }
//
//    override fun getRequestHeaders(): Map<String, String> {
//        return mWebResourceRequest.getRequestHeaders()
//    }
//
//    companion object {
//        fun adapter(x5Request: com.tencent.smtt.export.external.interfaces.WebResourceRequest): WebResourceRequestAdapter {
//            return WebResourceRequestAdapter(x5Request)
//        }
//    }
//}