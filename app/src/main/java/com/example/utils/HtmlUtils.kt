package com.example.utils

import android.content.Context
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import androidx.annotation.NonNull
import java.util.regex.Pattern

object HtmlUtils {

    @Suppress("Deprecation")
    fun fromHtml(@NonNull source: String): Spanned = Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY)
}