package com.grigor.kvartirka.data

import android.os.Build
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*


class HeaderInterceptor : Interceptor {

    //    private lateinit var context: Context
    override fun intercept(chain: Interceptor.Chain): Response {

        val clientID = UUID.randomUUID().toString()
//        val deviceID =
//            Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        val deviceOS = Build.VERSION.RELEASE

        var request = chain.request()
        request = request.newBuilder().addHeader("X-Client-ID: ", clientID)
            .addHeader("X—Client-ID: ", clientID)
            .addHeader("X-Device-ID","test")
            .addHeader(" X—ApplicationVersion: ", deviceOS)
            .build()
        return chain.proceed(request)
    }
}