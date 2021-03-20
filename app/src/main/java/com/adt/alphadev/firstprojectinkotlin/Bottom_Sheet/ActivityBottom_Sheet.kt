package com.adt.alphadev.firstprojectinkotlin.Bottom_Sheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.adt.alphadev.firstprojectinkotlin.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_bottom__sheet.*

class ActivityBottom_Sheet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom__sheet)


        val bottomSheetCallback = object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            override fun onStateChanged(bottomSheet: View, newState: Int) {}
        }

        val bottomSheetView = layoutInflater.inflate(R.layout.item_custom_layout_for_bottom_sheet, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView.parent as View)
        bottomSheetBehavior.setBottomSheetCallback(bottomSheetCallback)
        btn_bottom_sheet.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetDialog.show()
        }

    }
}