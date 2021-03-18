package com.chepsi.callbackdemo

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresPermission

class NetworkMonitor
@RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
constructor(private val application: Application) {

    fun startNetworkCallback() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val cm: ConnectivityManager =
                application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val builder: NetworkRequest.Builder = NetworkRequest.Builder()

            /**Check if version code is greater than API 24*/
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                cm.registerDefaultNetworkCallback(
                    networkCallback
                            as ConnectivityManager.NetworkCallback
                )
            } else {
                cm.registerNetworkCallback(
                    builder.build(),
                    networkCallback as ConnectivityManager.NetworkCallback
                )
            }
        }
    }

    fun stopNetworkCallback() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val cm: ConnectivityManager =
                application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            cm.unregisterNetworkCallback(ConnectivityManager.NetworkCallback())
        }
    }

    companion object {
        // for polling by older versions of android.
        fun checkNetworkConnection(application: Application): Boolean {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                val connectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE)
                GlobalVariables.isNetworkConnected =
                    if (connectivityManager is ConnectivityManager) {
                        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
                        networkInfo?.isConnected ?: false
                    } else false
            }
            return GlobalVariables.isNetworkConnected
        }
    }

    private var networkCallback:Any? = null
    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // install callback for newer versions of android.
            networkCallback = object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    GlobalVariables.isNetworkConnected = true
                }

                override fun onLost(network: Network) {
                    GlobalVariables.isNetworkConnected = false
                }
            }
        }
        else checkNetworkConnection(application)
    }

}