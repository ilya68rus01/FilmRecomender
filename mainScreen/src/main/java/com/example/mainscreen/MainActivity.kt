package com.example.mainscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    private fun inject() {
//        MainActivityComponent.Initializer
//            .init((applicationContext as App).getAppComponent())
//            .inject(this@MainActivity)
    }

}