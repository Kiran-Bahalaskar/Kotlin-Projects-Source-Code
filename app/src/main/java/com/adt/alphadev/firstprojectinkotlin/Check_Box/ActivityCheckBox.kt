package com.adt.alphadev.firstprojectinkotlin.Check_Box

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R
import java.lang.StringBuilder

class ActivityCheckBox : AppCompatActivity() {

    private lateinit var mouse: CheckBox
    private lateinit var keyboard: CheckBox
    private lateinit var LED: CheckBox
    private lateinit var calculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)

        mouse = findViewById(R.id.checkbox_1)
        keyboard = findViewById(R.id.checkbox_2)
        LED = findViewById(R.id.checkbox_2)
        calculate = findViewById(R.id.btn_calculate)

        calculate.setOnClickListener {
            var totalAmount: Int = 0
            val result = StringBuilder()
            result.append("Selected Items")

            if (mouse.isChecked){
                result.append("\nMouse 100rs")
                totalAmount += 100
            }

            if (keyboard.isChecked){
                result.append("\nKeyboard 50rs")
                totalAmount += 50
            }

            if (LED.isChecked){
                result.append("\nLED 120rs")
                totalAmount += 120
            }

            result.append("\nTotal: "+ totalAmount + "RS")
            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show()

        }

    }
}