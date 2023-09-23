package com.example.meetingcontainerdemo2

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.meetingcontainerdemo2.databinding.FragmentSecondBinding
import com.example.utils.HtmlUtils
import com.example.utils.initialize
import com.example.views.CookieUtils
import com.example.views.UCLoginWebViewClient


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            backPressed()
        }
    }

    @SuppressLint("JavascriptInterface")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.run {
            initializeWebView()
            binding.webView.isVisible = true
            binding.webView.addJavascriptInterface(JSBridge(), "android");
            binding.webView.loadUrl("file:///android_asset/web.html")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, onBackPressedCallback)
        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun backPressed() {
        Log.i(SecondFragment.TAG, "backPressed: ")
        if (isVisible) {
        }
        CookieUtils.clearCookies()
        findNavController().popBackStack()
    }

    private fun initializeWebView(){
        CookieUtils.clearCookies()
        val webViewClient = UCLoginWebViewClient { renderUrl(it) }

        binding.webView.initialize(webViewClient, "HTMLOUT")
        binding.webView.webChromeClient = UCLoginWebChromeClient()
    }

    open fun renderUrl(url: String) {
        if (isAdded) {
            val thePath = Uri.parse(url)
            val schema = thePath.scheme
            val domain = thePath.host
            val path = thePath.path
            // Let us configure all the colors in the string.
            val htmlString = getString(R.string.url_highlighter, schema, domain, path)
            val htmlSpannedString = HtmlUtils.fromHtml(htmlString)
        }
    }

    inner class UCLoginWebChromeClient : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            Log.i(TAG, "onProgressChanged: $newProgress")
            if (newProgress == SecondFragment.PROGRESS_COMPLETION) {
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.VISIBLE
            }

            binding.progressBar.progress = newProgress
            super.onProgressChanged(view, newProgress)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.webView.destroy()
        _binding = null
    }

    companion object {
        private const val TAG = "SecondFragment"
        private const val PROGRESS_COMPLETION = 100
    }
}