package com.codingwithset.fixaslabtask.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import com.codingwithset.fixaslabtask.utils.Exception
import okhttp3.Interceptor
import okhttp3.Response

/*
network connection handling.
 */
class NetworkConnectionInterceptor(
    context: Context
): Interceptor {
    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {

        if(isInternetAvailable()){
            return chain.proceed(chain.request())
        }
            Log.d("network ", "there is no internet"+isInternetAvailable())
            throw Exception.NoInternetException("make sure you have internet connection..." + isInternetAvailable())


    }


    private fun isInternetAvailable(): Boolean {
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw      = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            val nwInfo = connectivityManager.activeNetworkInfo ?: return false
            return nwInfo.isConnected
        }
    }




}