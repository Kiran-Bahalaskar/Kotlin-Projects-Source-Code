package com.adt.alphadev.firstprojectinkotlin.QR_Code

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.BarcodeEncoder
import kotlinx.android.synthetic.main.activity_q_r__code.*
import java.lang.Exception

class ActivityQR_Code : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q_r__code)

        btn_generate_qr_code.setOnClickListener {
           if (et_edit_text_qr_code.text.toString().length == 0){

               Toast.makeText(this, "Enter some text", Toast.LENGTH_SHORT).show()

           }else{
               generate_qr_code()
           }
        }

        btn_scan_qr_code.setOnClickListener {
           // startActivity(Intent(applicationContext, ActivityQR_code_scanner::class.java))
            val scanner = IntentIntegrator(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
            scanner.setBeepEnabled(false)
            scanner.initiateScan()
        }

    }

    private fun generate_qr_code(){
        val multiFormatWriter = MultiFormatWriter()

        try {
            val bitMatrix = multiFormatWriter.encode(et_edit_text_qr_code.text.toString().trim(), BarcodeFormat.QR_CODE, 300, 300)
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.createBitmap(bitMatrix)
            iv_qr_code.setImageBitmap(bitmap)

        }catch (e: WriterException){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK){
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null){
                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Scanned: "+ result?.contents, Toast.LENGTH_SHORT).show()
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}