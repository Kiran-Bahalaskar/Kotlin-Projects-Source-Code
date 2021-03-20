package com.adt.alphadev.firstprojectinkotlin.Image_Picker_And_Capture

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.adt.alphadev.firstprojectinkotlin.R
import kotlinx.android.synthetic.main.activity__image__picker__from__gallery.*

class Activity_Image_Picker_From_Gallery : AppCompatActivity() {

    private val pickupImage = 100
    private var ImageURI: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__image__picker__from__gallery)


        btn_pick_up_image.setOnClickListener {
            val picup_Image_From_Gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(picup_Image_From_Gallery, pickupImage)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickupImage){
            ImageURI = data?.data
            iv_image_view.setImageURI(ImageURI)

        }
    }
}