package com.taban.coronavirusstatistics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    val logTag = "My_Tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val t = Thread(Runnable {

            try {
                val apiResponse = URL("https://tal3898.github.io/CoronavirusStatistics/").readText()
                Log.i(logTag, "the resopnse from external data : " + apiResponse)

                val statisticsJson = JSONObject(apiResponse)
                val c = CoronaStatistics(1,2,3, "abcs")


                coronavirusCasesValueTxt.setText(c.coronaCases)
                deathsValueTxt.setText(c.deaths)
                recoveredValueTxt.setText(c.recovered)
                lastUpdateTimeValueTxt.setText(c.lastUpdateTime)

            } catch (e: Exception) {
                Log.e(logTag, "Could not load external stories", e)
            }


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
