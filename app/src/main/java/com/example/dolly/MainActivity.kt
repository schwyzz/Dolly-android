package com.example.dolly

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        webView.webViewClient = MyWebViewClient()
        // включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true)
        // указываем страницу загрузки
        webView.loadUrl("https://raw.githubusercontent.com/schwyzz/maxim-android/main/index.html")
    }

    class MyWebViewClient() : WebViewClient(), Parcelable {
        constructor(parcel: Parcel) : this() {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<MyWebViewClient> {
            override fun createFromParcel(parcel: Parcel): MyWebViewClient {
                return MyWebViewClient(parcel)
            }

            override fun newArray(size: Int): Array<MyWebViewClient?> {
                return arrayOfNulls(size)
            }
        }

    }
}