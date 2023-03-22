package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class bmiView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_view)

        val intent = intent
        val weight = intent.getFloatExtra("message_key", 9.7584F)
        val height = intent.getFloatExtra("message_key2", 9.8786F)

        val bmi = weight/((height/100)*(height/100))
        val idxBMI = String.format("%.2f",bmi).toFloat()
        displayResult(idxBMI)

    }
    private fun displayResult(bmi:Float){
        val result = findViewById<TextView>(R.id.bmiValue)
        val condition = findViewById<TextView>(R.id.conditionBMI)
        val card = findViewById<CardView>(R.id.bmiCard)
        val sugg = findViewById<TextView>(R.id.healthInfo)

        var resultText = ""
        var color = 0
        var description = ""

        result.text = bmi.toString()
        when{
            bmi < 18.50 ->{
                resultText = "Underweight"
                color = R.color.underweight
                description = "Concentrate on your Diet"
            }
            bmi in 18.50..24.99->{
                resultText = "Normal"
                color = R.color.normal
                description = "You are Healthy"
            }
            bmi in 24.99..29.99->{
                resultText = "Overweight"
                color = R.color.overweight
                description = "Concentrate on your Fitness"
            }
            bmi in 29.99..34.99->{
                resultText = "Obese"
                color = R.color.obese
                description = "Change your Diet immediately"
            }
            bmi > 34.99->{
                resultText = "Extremely Obese"
                color = R.color.extremelyObese
                description = "Word hard on your Fitness"
            }

        }
        condition.text= resultText
        card.setCardBackgroundColor(ContextCompat.getColor(this,color))
        sugg.text = description
    }
}