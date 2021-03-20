package com.adt.alphadev.firstprojectinkotlin.ProgressBar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.adt.alphadev.firstprojectinkotlin.R

class ActivityProgressBar : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var i = 0
    private var txtView: TextView? = null
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)

        progressBar = findViewById(R.id.progress_Bar)
        txtView = findViewById(R.id.text_view)
        val btn = findViewById<Button>(R.id.show_button)

        btn.setOnClickListener {
            i = progressBar!!.progress
            Thread(Runnable {

                while (i < 100){
                    i += 5

                    handler.post {
                        progressBar!!.progress = i
                        txtView!!.text = i.toString() + "/" + progressBar!!.max
                    }

                    try {
                        Thread.sleep(100)
                    }catch (e: InterruptedException){
                        e.printStackTrace()
                    }
                }
            }).start()
        }

    }
}