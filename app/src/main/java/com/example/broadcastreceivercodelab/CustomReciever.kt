package com.example.broadcastreceivercodelab

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReciever : BroadcastReceiver() {
    private val ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST"

    override fun onReceive(context: Context, intent: Intent) {

        val intentAction = intent.action
        if (intentAction != null) {
            var toastMessage = "unknown intent action"
            when (intentAction) {
                Intent.ACTION_POWER_CONNECTED -> toastMessage = "Power connected!"
                Intent.ACTION_POWER_DISCONNECTED -> toastMessage = "Power disconnected!"
                Intent.ACTION_HEADSET_PLUG -> {
                    toastMessage = when(intent.getIntExtra("state",-1)){
                        1-> "Headset is plugged in"
                        0-> "Headset is unplugged"
                        else -> return
                    }

                }
                ACTION_CUSTOM_BROADCAST -> toastMessage = "Custom Broadcast Received";

            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }
}