package com.svetlana.learn.broadcastcourse

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action){
            ACTION_CLICKED -> {
                val times = intent.getIntExtra(TIMES, 0)
                Toast.makeText(context, "CLICKED = $times times", Toast.LENGTH_SHORT).show()
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> {
                val turnedOn = intent.getBooleanExtra("state", false)
                Toast.makeText(
                    context,
                    "ACTION_AIRPLANE_turnedOn $turnedOn",
                    Toast.LENGTH_SHORT
                ).show()
            }
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context, "ACTION_BATTERY_LOW", Toast.LENGTH_SHORT).show()
            }
        }
    }


    companion object {

        const val ACTION_CLICKED = "clicked"
        const val TIMES = "times"
    }
}