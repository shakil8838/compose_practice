package com.example.composepractice.presentation

import android.os.Build
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


@Composable
fun YoutubePlayerView() {

    val iFramePlayerOptions: IFramePlayerOptions = IFramePlayerOptions.Builder()
        .controls(1)
        .fullscreen(1)
        .build()

    val playerListener = object : AbstractYouTubePlayerListener() {
        override fun onReady(youTubePlayer: YouTubePlayer) {
            youTubePlayer.loadVideo("a18py61_F_w", 0f)
        }
    }

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        factory = { context ->
//            YouTubePlayerView(context = context)
//                .apply {
//                    addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
//                        override fun onReady(youTubePlayer: YouTubePlayer) {
//                            youTubePlayer.loadVideo("a18py61_F_w", 0f)
//                        }
//                    })
//
//                    addFullscreenListener(object : FullscreenListener {
//                        override fun onEnterFullscreen(
//                            fullscreenView: View,
//                            exitFullscreen: Function0<Unit>
//                        ) {
//
//                        }
//
//                        override fun onExitFullscreen() {}
//                    })
//                }

            WebView(context).apply {
                val webSettings: WebSettings = this.settings
                webSettings.javaScriptEnabled = true
                webSettings.loadWithOverviewMode = true
                webSettings.cacheMode = WebSettings.LOAD_DEFAULT
                webSettings.userAgentString =
                    "Mozilla/5.0 (Linux; Android ${Build.VERSION.SDK_INT}; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19"
                webSettings.allowContentAccess = true
                webSettings.allowFileAccess = true
                webSettings.javaScriptCanOpenWindowsAutomatically = true

                this.webViewClient = object : android.webkit.WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        view?.loadUrl("https://www.youtube.com/watch?v=a18py61_F_w")
                        return true
                    }
                }
            }
        })
}

@Composable
@Preview
fun YoutubePlayerViewPreview() {
    YoutubePlayerView()
}