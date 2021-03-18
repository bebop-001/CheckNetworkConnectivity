package com.chepsi.callbackdemo

import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import com.chepsi.callbackdemo.GlobalVariables.isNetworkConnected
import kotlin.properties.Delegates

object GlobalVariables {
    var isNetworkConnected: Boolean by Delegates.observable(false) { property, oldValue, newValue ->
        Log.i("Network connectivity", "$newValue")
    }
    fun isNetworkConnected(application: Application) : Boolean {
        // need to poll for pre 21.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            NetworkMonitor.checkNetworkConnection(application)
        return isNetworkConnected
    }
}