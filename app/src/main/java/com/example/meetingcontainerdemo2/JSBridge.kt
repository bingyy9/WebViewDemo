package com.example.meetingcontainerdemo2;

import android.util.Log
import android.webkit.JavascriptInterface
import android.widget.Toast

class JSBridge {
    @JavascriptInterface
    fun toastMessage(message: String) {
        Log.i("JSBridge", "toastMessage: $message")
        Toast.makeText(MyApplication.applicationContext(), "Toast:$message", Toast.LENGTH_LONG).show()
    }
}
