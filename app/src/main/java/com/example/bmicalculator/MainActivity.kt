package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightText =  findViewById<EditText>(R.id.weightInput)
        val heightText =  findViewById<EditText>(R.id.heightInput)
        val calcButton =  findViewById<Button>(R.id.btncalculate)

        calcButton.setOnClickListener{
            val weight = weightText.text.toString().toFloat()
            val height = heightText.text.toString().toFloat()

            val intent = Intent(this, bmiView::class.java ).also {
                it.putExtra("message_key", weight)
                it.putExtra("message_key2", height)
                startActivity(it)
            }

        }
        }
    }

