package com.example.gceolmcq

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData

class NetworkConnectionLiveData(private val connectivityManager: ConnectivityManager): LiveData<Boolean>(){
    constructor(application: Application): this(application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
    private val networkCallback = @RequiresApi(Build.VERSION_CODES.LOLLIPOP)

    object: ConnectivityManager.NetworkCallback(){
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            println("network available")
            postValue(true)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            println("network unavailable")
            postValue(false)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onActive() {
        super.onActive()
        println("network active")
        val builder = NetworkRequest.Builder()
        connectivityManager.registerNetworkCallback(builder.build(), networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        println("network inactive")
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}