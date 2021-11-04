package com.example.media_palyer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var mediaPlayer : MediaPlayer? = null
    private var currentSong = mutableListOf(R.raw.foster_the_people__pumped_up_kicks)
    private lateinit var playButton: Button
    private lateinit var pauseButton: Button
    private lateinit var stopButton: Button
    private lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        controlSound(currentSong[0])

        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.foster_the_people__pumped_up_kicks)
        findViewById<Button>(R.id.play_fab).setOnClickListener { mediaPlayer!!.start() }

        }

//    private fun controlSound(id:Int){
//
//        playButton.setOnClickListener {
//
//            if (mediaPlayer == null){
//                mediaPlayer = MediaPlayer.create(this, id)
//                Log.d("MainActivity", "ID is ${mediaPlayer!!.audioSessionId}")
//
//                initialiseSeekBar()
//            }
//            mediaPlayer?.start()
//            Log.d("MainActivity", "Duration is ${mediaPlayer!!.duration/1000} seconds")
//        }
//
//        pauseButton.setOnClickListener {
//            if (mediaPlayer != null) mediaPlayer?.pause()
//            Log.d("MainActivity", "Paused at ${mediaPlayer!!.currentPosition/1000} seconds")
//        }
//
//        stopButton.setOnClickListener {
//            if (mediaPlayer != null){
//                mediaPlayer?.stop()
//                mediaPlayer?.reset()
//                mediaPlayer?.release()
//                mediaPlayer = null
//            }
//        }
//
//        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                if (fromUser) mediaPlayer?.seekTo(progress)
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//            }
//        } )
//    }
//    private fun initialiseSeekBar(){
//        seekBar.max = mediaPlayer!!.duration
//
//        val handler = Handler()
//        handler.postDelayed(object: Runnable{
//            override fun run() {
//                try {
//                    seekBar.progress = mediaPlayer!!.currentPosition
//                    handler.postDelayed(this, 1000)
//                } catch (e: Exception) {
//                    seekBar.progress = 0
//                }
//            }
//        }, 1000)
//
//    }

}