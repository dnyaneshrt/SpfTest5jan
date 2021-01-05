package com.tech.spftest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fMananger=supportFragmentManager
        var tx=fMananger.beginTransaction()
        tx.add(R.id.my_frame,LoginFrag())
        tx.commit()
    }
}