package com.adt.alphadev.firstprojectinkotlin.PDF_Generator

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import kotlinx.android.synthetic.main.activity_p_d_f__generator.*
import java.io.FileOutputStream
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest

class ActivityPDF_Generator : AppCompatActivity() {

    private val STORAGE_CODE = 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p_d_f__generator)

        btn_generate_pdf.setOnClickListener {

            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_DENIED
                ) {
                    val permission = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permission, STORAGE_CODE)
                }else{
                    savePDF()
                }
            }else{
                savePDF()
            }
        }

    }

    private fun savePDF(){
        val mDoc = Document()
        val mFileName = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(System.currentTimeMillis())
        val mFilePath = Environment.getExternalStorageDirectory().toString() + "/" + mFileName +".pdf"

        try {
            PdfWriter.getInstance(mDoc, FileOutputStream(mFilePath))
            mDoc.open()
            val mText = et_edit_text_pdf.text.toString().trim()
            mDoc.addAuthor("Kiran Bahalaskar")
            mDoc.add(Paragraph(mText))
            mDoc.close()
            Toast.makeText(this, "$mFileName.pdf\nis save to\n$mFilePath", Toast.LENGTH_SHORT).show()
        }catch (e: Exception){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            STORAGE_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    savePDF()
                }else{
                    Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}