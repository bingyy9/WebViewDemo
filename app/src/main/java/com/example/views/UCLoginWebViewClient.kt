package com.example.views

import android.graphics.Bitmap
import android.net.http.SslError
import android.util.Log
import android.webkit.*
import com.example.meetingcontainerdemo2.MyApplication
import com.example.utils.UCBrowserLoginSSONavResult
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptor
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptorInst
import java.io.File
import kotlin.math.max


class UCLoginWebViewClient(
//    val showAuthDialog: (handler: HttpAuthHandler?, host: String?) -> Unit,
    private val renderUrl: (url: String) -> Unit,
) : WebViewClient() {
    private var runningUrlCount = 0

    init{
        Log.i("UCLoginWebViewClient", "init: ")
        val builder = WebViewCacheInterceptor.Builder(MyApplication.applicationContext())
        builder.setCachePath(File(MyApplication.applicationContext().cacheDir, "cache_path_name")) //设置缓存路径，默认getCacheDir，名称CacheWebViewCache
            .setDynamicCachePath(File(MyApplication.applicationContext().cacheDir, "dynamic_webview_cache"))
            .setCacheSize((1024 * 1024 * 100).toLong()) //设置缓存大小，默认100M
            .setConnectTimeoutSecond(20) //设置http请求链接超时，默认20秒
            .setReadTimeoutSecond(20) //设置http请求链接读取超时，默认20秒
//            .setCacheType(CacheType.NORMAL) //设置缓存为正常模式，默认模式为强制缓存静态资源

        //CacheWebview可以从Assets路径加载静态资源，只要设置了Assets路径就是开启此功能，默认未开启；
        //默认精确匹配地址规则
        builder.setAssetsDir("static");

        //后缀匹配规则
        //builder.isAssetsSuffixMod(true);
        //WebViewCacheInterceptorInst.getInstance().initAssetsData(); //后台线程获取Assets文件资源

//        builder.setResourceInterceptor {
//            true //按照默认规则，false 不拦截资源
//        }

        WebViewCacheInterceptorInst.getInstance().init(builder);
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        if (!url.isNullOrEmpty()) {
            renderUrl(url)
        }
        runningUrlCount = max(runningUrlCount, 1)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        if (!url.isNullOrEmpty()) {
            renderUrl(url)
        }
        runningUrlCount--
        if (runningUrlCount == 0) {
            view?.loadUrl(getJSHtmlLoaderString())
        }
    }

    // This method only works under Android M(6.0), DO NOT remove this method or it will crash under M
    override fun onReceivedError(view: WebView, errorCode: Int, description: String?, failingUrl: String?) {
        processSSOSignInResult(getLoginSSONavResult(errorCode), view.url, "")
    }

    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
        handler.cancel()
    }

    override fun onReceivedHttpError(view: WebView?, request: WebResourceRequest, errorResponse: WebResourceResponse) {
        val err = errorResponse.statusCode
        super.onReceivedHttpError(view, request, errorResponse)
        if (request.isForMainFrame) {
            if (err == 401) { // Auth required, will handle in onReceivedHttpAuthRequest();
                return
            }
//            processSSOSignInResult(getLoginSSONavResult(err), request.url.toString(), "")
        }
    }

    override fun onReceivedLoginRequest(view: WebView?, realm: String?, account: String?, args: String?) {
    }

    override fun onReceivedHttpAuthRequest(view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) {
//        showAuthDialog(handler, host)
    }

    override fun onReceivedClientCertRequest(view: WebView, request: ClientCertRequest) {
//        val hostName = Uri.parse(browserViewModel.ssoUrl).host
//
//        if (request.host.equals(hostName, true) && browserViewModel.isEdgeConnectivityAvailable()) {
//            request.ignore()
//        } else {
//            TeamsLogger.debug(UC_TAG, "execute client certificate for HTTP request of IdP")
//            ClientCertificateRequest(request, settings).handleClientCertRequest()
//        }
    }

    override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest): WebResourceResponse? {
//        if (!request.isForMainFrame && request.url.path!!.contains("/favicon.ico")) {
//            try {
//                return WebResourceResponse("image/png", null, null)
//            } catch (e: Exception) {
//            }
//        }
//        return null
        return  WebViewCacheInterceptorInst.getInstance().interceptRequest(request);
    }

    override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse? {
        return  WebViewCacheInterceptorInst.getInstance().interceptRequest(url);
    }

    private fun getLoginSSONavResult(statusCode: Int): UCBrowserLoginSSONavResult {
        return when (statusCode) {
            in 500..599 -> UCBrowserLoginSSONavResult.FailedWith5xx
            in 400..499 -> UCBrowserLoginSSONavResult.FailedWith4xx
            in 100..399 -> UCBrowserLoginSSONavResult.Success
            else -> UCBrowserLoginSSONavResult.UnknownError
        }
    }

    private fun processSSOSignInResult(ssoNavResult: UCBrowserLoginSSONavResult, url: String?, document: String?) {
//        browserViewModel.ucProcessSSOSignInResult(ssoNavResult, url, document)
    }

    private fun getJSHtmlLoaderString(): String {
        return "javascript: var wholeBody = document.documentElement.innerHTML; HTMLOUT.processHTML(wholeBody,window.location.href); "
    }

    @JavascriptInterface
    fun processHTML(html: String, url: String) {
        processSSOSignInResult(UCBrowserLoginSSONavResult.Success, url, html)
    }

    override fun onLoadResource(view: WebView?, url: String) {
        var url = url
        Log.i(TAG, "onLoadResource: $url")
        super.onLoadResource(view, url)
    }

    companion object{
        private const val TAG = "UCLoginWebViewClient"
    }
}
