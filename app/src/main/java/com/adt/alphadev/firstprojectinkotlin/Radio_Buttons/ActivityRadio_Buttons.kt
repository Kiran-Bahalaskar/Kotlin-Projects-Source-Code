package com.adt.alphadev.firstprojectinkotlin.Radio_Buttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R
import kotlinx.android.synthetic.main.activity_radio__buttons.*

class ActivityRadio_Buttons : AppCompatActivity() {

    private lateinit var radioButtons: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio__buttons)


        btn_radio_gender.setOnClickListener {
            val intSelectButton: Int = rg_radio_group.checkedRadioButtonId
            radioButtons = findViewById(intSelectButton)
            Toast.makeText(this, radioButtons.text, Toast.LENGTH_SHORT).show()
        }


    }
}