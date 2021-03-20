package com.adt.alphadev.firstprojectinkotlin.AlertDiag

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.adt.alphadev.firstprojectinkotlin.R
import kotlinx.android.synthetic.main.activity_alert_dialog.*

class ActivityAlertDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        btn_alert_Dialog.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Simple Alert Dialog")
            builder.setMessage("This my Alert Dialog")
            builder.setIcon(R.drawable.ic_launcher_background)


            builder.setPositiveButton("YES"){dialogInterface, which ->
                Toast.makeText(this, "Yes Click", Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(this, "No Click", Toast.LENGTH_SHORT).show()
            }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()

        }

        btn_custom_alert_Dialog.setOnClickListener {

            custom_Alert_Dialog()

        }

    }

    private fun custom_Alert_Dialog() {

        val dialog = Dialog(this)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.item_alert_dialog_layout)
        val btn_msg = dialog.findViewById<Button>(R.id.btn_msg_alert)
        val btn_close = dialog.findViewById<ImageView>(R.id.btn_close)

        btn_msg.setOnClickListener {
            Toast.makeText(this, "Click msg", Toast.LENGTH_SHORT).show()
        }

        btn_close.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }
}