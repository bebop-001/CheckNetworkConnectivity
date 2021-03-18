package com.chepsi.callbackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var helloTV: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloTV = findViewById(R.id.hello_TV)
        if (Variables.isNetworkConnected){
            helloTV.setText("Hello.  Network is connected")
        }
        else {
            helloTV.setText("Hello.  Failed to get network connection.")
        }
    }
}