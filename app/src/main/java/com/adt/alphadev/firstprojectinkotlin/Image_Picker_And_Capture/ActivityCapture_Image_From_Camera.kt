package com.adt.alphadev.firstprojectinkotlin.Image_Picker_And_Capture

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.adt.alphadev.firstprojectinkotlin.R
import kotlinx.android.synthetic.main.activity_capture__image__from__camera.*

class ActivityCapture_Image_From_Camera : AppCompatActivity() {

    val CAMERA_REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capture__image__from__camera)


        btn_capture_image.setOnClickListener {
            val callcameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (callcameraIntent.resolveActivity(packageManager) != null){
                startActivityForResult(callcameraIntent, CAMERA_REQUEST_CODE)
            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            CAMERA_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK && data != null){
                    iv_camera_imageview.setImageBitmap(data.extras?.get("data") as Bitmap)
                }
            } else ->{
                Toast.makeText(this, "unrecognized request code", Toast.LENGTH_SHORT).show()
            }
        }
    }
}