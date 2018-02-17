package com.example.estevaocoelho.lottieanimations

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by estevaocoelho on 16/02/18.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        animationView.setAnimation("animation_1.json")

        animationView.repeatCount = ValueAnimator.INFINITE

        buttonPlayPause.setOnClickListener({
            if (buttonPlayPause.text == "PAUSE") {
                pauseAnimation()
            } else {
                playAnimation()
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                animationView.progress = seekBar.progress/25F
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })
    }

    private fun playAnimation() {
        buttonPlayPause.text = "PAUSE"
        animationView.playAnimation()
    }

    private fun pauseAnimation() {
        buttonPlayPause.text = "PLAY"
        animationView.pauseAnimation()
    }
}
