package com.example.meetingcontainerdemo2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.meetingcontainerdemo2.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            loadUrl()
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        initWebView()
    }
    
    private fun initWebView(){
        val webSettings: WebSettings = binding.webView.getSettings()
        webSettings.setJavaScriptEnabled(true)

    }

    private fun loadUrl(){
        binding.webView.loadUrl("https://www.baidu.com")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}