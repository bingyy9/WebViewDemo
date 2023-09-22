package com.example.views

import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.webkit.ClientCertRequest
import android.webkit.HttpAuthHandler
import android.webkit.JavascriptInterface
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.utils.UCBrowserLoginSSONavResult
import kotlin.math.max

class UCLoginWebViewClient(
//    val showAuthDialog: (handler: HttpAuthHandler?, host: String?) -> Unit,
    private val renderUrl: (url: String) -> Unit,
) : WebViewClient() {
    private var runningUrlCount = 0

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
        if (!request.isForMainFrame && request.url.path!!.contains("/favicon.ico")) {
            try {
                return WebResourceResponse("image/png", null, null)
            } catch (e: Exception) {
            }
        }
        return null
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
}
