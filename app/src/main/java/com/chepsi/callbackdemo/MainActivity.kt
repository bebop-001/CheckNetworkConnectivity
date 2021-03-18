package com.chepsi.callbackdemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.chepsi.callbackdemo.GlobalVariables.isNetworkConnected

class MainActivity : AppCompatActivity() {
    lateinit var helloTV: TextView
    lateinit var updateStatusButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloTV = findViewById(R.id.hello_TV)
        updateStatusButton = findViewById(R.id.update_net_statis_BTN)
        updateStatusButton.setOnClickListener {
            helloTV.setText(
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (isNetworkConnected) R.string.net_is_connected
                    else R.string.net_is_not_connected
                }
                else if (isNetworkConnected(application)) R.string.net_is_connected
                else R.string.net_is_not_connected
            )
        }
        if (isNetworkConnected) {
            helloTV.text = getString(R.string.net_is_connected)
        }
        else {
            helloTV.text = getString(R.string.net_is_not_connected)
        }
    }
}