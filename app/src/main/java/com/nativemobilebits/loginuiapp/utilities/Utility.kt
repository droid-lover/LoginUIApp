package com.nativemobilebits.loginuiapp.utilities

import android.app.Activity
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object Utility {

    fun loadJSONFromAsset(activity: Activity): String? {
        var json: String? = null
        json = try {
            val `is`: InputStream = activity.assets.open("response.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charset.forName("utf-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}