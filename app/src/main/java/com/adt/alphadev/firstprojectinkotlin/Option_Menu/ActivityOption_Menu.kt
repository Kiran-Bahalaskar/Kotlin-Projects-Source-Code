package com.adt.alphadev.firstprojectinkotlin.Option_Menu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.adt.alphadev.firstprojectinkotlin.R

class ActivityOption_Menu : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option__menu)

        toolbar = findViewById(R.id.my_toolbar)
        toolbar.title = "My Toolbar"
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.nav_home -> {
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_profile -> {
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_settings -> {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

}