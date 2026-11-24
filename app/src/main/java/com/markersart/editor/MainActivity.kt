
package com.markersart.editor

import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {

    private var player: ExoPlayer? = null
    private lateinit var playerView: PlayerView
    private lateinit var status: TextView

    private val pickVideo =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri: Uri? ->
            uri?.let {
                status.text = "Video selected successfully"
                player?.setMediaItem(MediaItem.fromUri(it))
                player?.prepare()
                player?.play()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 32, 24, 24)
            gravity = Gravity.CENTER_HORIZONTAL
            setBackgroundColor(0xFF101014.toInt())
        }

        val heading = TextView(this).apply {
            text = "MARKERS ART"
            textSize = 28f
            setTextColor(0xFFFFFFFF.toInt())
            gravity = Gravity.CENTER
        }

        status = TextView(this).apply {
            text = "Your Pro Video Editor"
            textSize = 16f
            setTextColor(0xFFCCCCCC.toInt())
            gravity = Gravity.CENTER
        }

        playerView = PlayerView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 600
            )
        }

        val importButton = Button(this).apply {
            text = "Import Video"
            setOnClickListener {
                pickVideo.launch(arrayOf("video/*"))
            }
        }

        root.addView(heading)
        root.addView(status)
        root.addView(playerView)
        root.addView(importButton)

        setContentView(root)
    }

    override fun onStart() {
        super.onStart()
        player = ExoPlayer.Builder(this).build()
        playerView.player = player
    }

    override fun onStop() {
        playerView.player = null
        player?.release()
        player = null
        super.onStop()
    }
}
