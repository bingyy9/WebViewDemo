package com.example.meetingcontainerdemo2

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.meetingcontainerdemo2.databinding.FragmentFirstBinding
import com.example.utils.HtmlUtils
import com.example.utils.initialize
import com.example.views.CookieUtils
import com.example.views.UCLoginWebViewClient

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            backPressed()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.run {
            initializeWebView()
            binding.webView.loadUrl("https://user.dmz.webex.com")
        }
        return binding.root

    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, onBackPressedCallback)
        binding.buttonFirst.setOnClickListener {
            reload()
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
    
    private fun reload(){
        Log.i(TAG, "reload: ")
        binding.webView.reload()
        binding.webView.isVisible = true
//        binding.run {
//            initializeWebView()
//            binding.webView.loadUrl("https://user.dmz.webex.com")
//        }
    }

    private fun backPressed() {
        Log.i(TAG, "backPressed: ")
        if (isVisible) {
        }
        CookieUtils.clearCookies()
        findNavController().popBackStack()
    }
    
    private fun initializeWebView(){
        CookieUtils.clearCookies()
        val webViewClient = UCLoginWebViewClient(
//            { handler, host -> showDialog(handler, host) },
            { renderUrl(it) },
        )

        binding.webView.initialize(webViewClient, "HTMLOUT")
        binding.webView.webChromeClient = UCLoginWebChromeClient()
//        renderUrl("https://user.dmz.webex.com")
        binding.webView.isVisible = false
    }

    open fun renderUrl(url: String) {
        if (isAdded) {
            val thePath = Uri.parse(url)

            // 1 color for semi important stuff
            // 2 protocol http|https
            // 3 color of non-important stuff
            // 4 color of domain
            // 5 highlighted domain
            // 6 the rest of the url

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
            if (newProgress == Companion.PROGRESS_COMPLETION) {
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.VISIBLE
            }

            binding.progressBar.progress = newProgress
            super.onProgressChanged(view, newProgress)
        }
    }

    companion object {
        private const val TAG = "FirstFragment"
        private const val PROGRESS_COMPLETION = 100
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, "onDestroyView: ")
        binding.webView.destroy()
        _binding = null
    }
}