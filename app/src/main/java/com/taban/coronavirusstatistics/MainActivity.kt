package com.taban.coronavirusstatistics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    val logTag = "My_Tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t = Thread(Runnable {



            /* a code which try to read from the worldometers
            try {
                val apiResponse = URL("https://www.worldometers.info/coronavirus/").readText()
                Log.i(logTag, "1:" + apiResponse)
                Log.i(logTag, "1.1:" + apiResponse.substring(apiResponse.length - 100))
            } catch (e:Exception) {
                Log.e(logTag, "could not read data tal", e)
            }

            */

            /* a library code
            //     implementation 'com.koushikdutta.ion:ion:2.1.8'
            try {
                Ion.with(applicationContext).load("https://www.worldometers.info/coronavirus/").asString()
                    .setCallback { e, result -> Log.i(logTag, "2:" + result) }
            } catch (e:Exception) {
                Log.e(logTag, "could not again", e)
            }
            */
        })
        t.start()


    }


}
