package com.example.broadcastreceivercodelab

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {
    val reciever = CustomReciever()
    private val ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        filter.addAction(Intent.ACTION_HEADSET_PLUG)
        registerReceiver(reciever,filter)
        LocalBroadcastManager.getInstance(this).registerReceiver(reciever,
            IntentFilter(ACTION_CUSTOM_BROADCAST)
        )
    }

    override fun onDestroy() {
        unregisterReceiver(reciever)
        LocalBroadcastManager.getInstance(this).unregisterReceiver(reciever)
        super.onDestroy()
    }

    fun sendCustomBroadcast(view: View) {

        val customBroadcastIntent = Intent(ACTION_CUSTOM_BROADCAST)
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);


    }


}