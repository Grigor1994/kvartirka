package com.grigor.kvartirka.data

import android.content.Context
import android.os.Build
import android.provider.Settings.Secure
import com.grigor.kvartirka.App
import okhttp3.Interceptor
import okhttp3.Response
import java.io.UnsupportedEncodingException
import java.security.AccessController.getContext
import java.util.*


class HeaderInterceptor : Interceptor {

        private lateinit var context: Context
    override fun intercept(chain: Interceptor.Chain): Response {

        val clientID = UUID.randomUUID().toString()
//        val deviceID =
//            Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        val deviceOS = Build.VERSION.RELEASE

        var request = chain.request()
        request = request.newBuilder()
            .addHeader("XClientID:", clientID)
            .addHeader("XDeviceID:","test")
            .addHeader("XApplicationVersion:", deviceOS)
            .build()
        return chain.proceed(request)
    }

//    fun getDeviceId(): String? {
//          App.getContext()
//        val androidId =
//            Secure.getString(context.getContentResolver(), Secure.ANDROID_ID)
//        val uuid: UUID
//        uuid = try {
//            if (androidId != null) UUID.nameUUIDFromBytes(androidId.toByteArray(charset("utf8"))) else UUID.randomUUID()
//        } catch (e: UnsupportedEncodingException) {
//            Log.d("in", e.getMessage(), e)
//            UUID.randomUUID()
//        }
//        return uuid.toString()
//    }
}