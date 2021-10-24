package com.example.mainscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.core.App
import com.example.core.actions.ShowNewFilmsAction
import com.example.mainscreen.databinding.ActivityMainBinding
import com.example.mainscreen.di.component.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var showNewFilmsAction: ShowNewFilmsAction

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setContentView(R.layout.activity_main)
    }

    private fun inject() {
//        MainActivityComponent.Initializer
//            .init((applicationContext as App).getAppComponent())
//            .inject(this@MainActivity)
    }

}