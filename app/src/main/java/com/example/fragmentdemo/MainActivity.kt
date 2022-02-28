package com.example.fragmentdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        val btnA : Button = findViewById(R.id.btnA)
        val btnB : Button = findViewById(R.id.btnB)
        val btnSetData : Button = findViewById(R.id.btnSetData)

        btnA.setOnClickListener{
            val fragmentTransaction = fragmentManager.beginTransaction()

            val fragmentA = AFragment()
            fragmentTransaction.replace(R.id.fragmentContainerView, fragmentA)
            fragmentTransaction.commit()
        }

        btnB.setOnClickListener{
            val fragmentTransaction = fragmentManager.beginTransaction()

            val fragmentB = BFragment()
            fragmentTransaction.replace(R.id.fragmentContainerView, fragmentB)
            fragmentTransaction.commit()
        }

        btnSetData.setOnClickListener{
            val fragment = fragmentManager.findFragmentById(R.id.fragmentContainerView) as AFragment


            fragment.requireView().findViewById<TextView>(R.id.tvA).text = "Hello, how are you?"
        }
    }
}