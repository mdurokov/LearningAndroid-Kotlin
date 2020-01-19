package com.mdurokov.firstkotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.textView)
        textView.text = "Hello Fam!"

        var button1 = findViewById<Button>(R.id.btn1)
        var buttonReset = findViewById<Button>(R.id.btn2)
        button1.setOnClickListener {
            counter++
            textView.text = counter.toString()
        }

        buttonReset.setOnClickListener {
            counter = 0
            textView.setText(counter.toString())
        }
    }

}
