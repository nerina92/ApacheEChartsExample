package com.apacheechartsexample

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.apacheechartsexample.ui.theme.ApacheEChartsExampleTheme
import com.google.gson.Gson
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.DisposableEffect

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApacheEChartsExampleTheme {
                Scaffold(modifier = Modifier
                    .fillMaxHeight()
                    .padding(20.dp)) { innerPadding ->
                    //column scrollable
                    LazyColumn(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {
                        item { kpiVentas() }
                        item {EChartView("file:///android_asset/echarts.html") }
                        item {EChartView("file:///android_asset/area-pieces.html") }
                        item {EChartView("file:///android_asset/torta-lineas.html") }
                        item {EChartView2("file:///android_asset/dinamic-chart.html") }
                    }
                }
            }
        }
    }
}

@Composable
fun EChartView(url: String ){

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        AndroidView(
            modifier = Modifier,
            factory = {
                WebView(it).apply {
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    loadUrl(url)
                    this.viewTreeObserver.addOnGlobalLayoutListener {
                        Log.d("WebView", "Width: ${this.width}, Height: ${this.height}")
                    }
                }
            }
        )
    }

}

@Composable
fun EChartView2(url:String) {
    val context = LocalContext.current
    val webView = remember { WebView(context) }

    DisposableEffect(webView) {
        onDispose {
            webView.destroy()
        }
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        AndroidView(
            modifier = Modifier,
            factory = {
                webView.apply {
                    webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView?, url: String?) {
                            super.onPageFinished(view, url)

                            // Example of data to send to the WebView
                            val data = listOf(200, 250, 300,100,250,150)
                            // Convert data to JSON string
                            val jsonData = Gson().toJson(data)
                            Log.d("JsonData", jsonData)
                            // Call JavaScript function in WebView to update chart data
                            evaluateJavascript("updateChartData('$jsonData')", null)
                        }
                    }
                    settings.javaScriptEnabled = true
                    loadUrl(url)
                }
            }
        )
    }
    // Example of data to send to the WebView
    val data = listOf(
        200, 250, 300
    )
    // Convert data to JSON string
    val jsonData = Gson().toJson(data)
    Log.d("JsonData", jsonData)
    // Call JavaScript function in WebView to update chart data
    webView.evaluateJavascript("updateChartData('$jsonData')", null)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApacheEChartsExampleTheme {
        EChartView("file:///android_asset/area-pieces.html")
    }
}

@Preview
@Composable
private fun () {
    
}

