package com.example.media_palyer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.SeekBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var mediaPlayer : MediaPlayer? = null
    private var currentSong = mutableListOf(R.raw.foster_the_people__pumped_up_kicks)
    private lateinit var playButton: FloatingActionButton
    private lateinit var pauseButton: FloatingActionButton
    private lateinit var stopButton: FloatingActionButton
    private lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controlSound(currentSong[0])
        }

    private fun controlSound(id:Int){                       //function that controls the media player
        playButton = findViewById(R.id.play_fab)
        pauseButton = findViewById(R.id.pause_fab)
        stopButton = findViewById(R.id.stop_fab)
        seekBar = findViewById(R.id.seekbar)
//set play button to play song if there's no song playing
        playButton.setOnClickListener {
            if (mediaPlayer == null){
                mediaPlayer = MediaPlayer.create(this, id)

                initialiseSeekBar()
            }
            mediaPlayer?.start()
        }
//set pause button if there's a song playing
        pauseButton.setOnClickListener {
            if (mediaPlayer != null) mediaPlayer?.pause()
        }
//set stop button to stop playing song and release the service after the song stops
        stopButton.setOnClickListener {
            if (mediaPlayer != null){
                mediaPlayer?.stop()
                mediaPlayer?.reset()
                mediaPlayer?.release()
                mediaPlayer = null
            }
        }
//control the progress of playing song with seekbar
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mediaPlayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

//    function to initialise the seekbar
    private fun initialiseSeekBar(){
        seekBar.max = mediaPlayer!!.duration

        val handler = Handler()
        handler.postDelayed(object: Runnable{
            override fun run() {
                try {
                    seekBar.progress = mediaPlayer!!.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e: Exception) {
                    seekBar.progress = 0
                }
            }
        }, 1000)
    }
}