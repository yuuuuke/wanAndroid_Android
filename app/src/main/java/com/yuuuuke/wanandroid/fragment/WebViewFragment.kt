package com.yuuuuke.wanandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.yuuuuke.wanandroid.R

class WebViewFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_webview,container,false)
        view.findViewById<TextView>(R.id.tv_title).text = arguments?.getString("TITLE")?:""
        val webView = view.findViewById<WebView>(R.id.web_view)
        webView.loadUrl(arguments?.getString("URL")?:"")
        webView.webViewClient = object:WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return true
            }
        }
        return view
    }

}