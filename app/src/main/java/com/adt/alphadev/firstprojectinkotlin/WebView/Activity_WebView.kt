package com.adt.alphadev.firstprojectinkotlin.WebView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.adt.alphadev.firstprojectinkotlin.R

class Activity_WebView : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__web_view)

        webView = findViewById(R.id.webView)
        webView.loadUrl("https://www.google.com/")

    }
}