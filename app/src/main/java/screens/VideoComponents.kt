package com.example.stretchingapp.screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.rememberAsyncImagePainter

data class VideoItem(val videoId: String, val title: String)

@Composable
fun VideoCard(video: VideoItem, onClick: (VideoItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(video) },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column {
            val thumbnailUrl = "https://img.youtube.com/vi/${video.videoId}/0.jpg"
            Image(
                painter = rememberAsyncImagePainter(thumbnailUrl),
                contentDescription = video.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            )

            Text(
                text = video.title,
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun YouTubePlayer(videoId: String) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadData(
                    """
                    <html>
                        <body style="margin:0;padding:0;">
                            <iframe width="100%" height="200" 
                                src="https://www.youtube.com/embed/$videoId?autoplay=1" 
                                frameborder="0" allowfullscreen>
                            </iframe>
                        </body>
                    </html>
                    """.trimIndent(),
                    "text/html",
                    "utf-8"
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    )
}
