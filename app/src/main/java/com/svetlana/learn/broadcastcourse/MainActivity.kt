package com.svetlana.learn.broadcastcourse

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.svetlana.learn.broadcastcourse.MyReceiver.Companion.ACTION_CLICKED

class MainActivity : AppCompatActivity() {

    private val receiver = MyReceiver()
    var times = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            Intent(ACTION_CLICKED).apply {
                putExtra(MyReceiver.TIMES, times++)
                sendBroadcast(this)
            }
        }
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(MyReceiver.ACTION_CLICKED)
        }

        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}