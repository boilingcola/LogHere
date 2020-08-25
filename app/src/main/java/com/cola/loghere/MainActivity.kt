package com.cola.loghere

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cola.ezlog.EzLog
import com.cola.ezlog.LogLevel

class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EzLog.setlogOpen(true);
        EzLog.logLevel = LogLevel.VERBOSE.level;
        EzLog.d(TAG, "test application is onCreate");

    }
}