package com.chepsi.callbackdemo

import android.app.Application

// root application class for CallbackDemo
class CheckNetworkConnectivity : Application(){
    override fun onCreate() {
        super.onCreate()
        //Start network callback
        NetworkMonitor(this).startNetworkCallback()
    }

    override fun onTerminate(){
        super.onTerminate()
        //Stop network callback
        NetworkMonitor(this).stopNetworkCallback()
    }
}