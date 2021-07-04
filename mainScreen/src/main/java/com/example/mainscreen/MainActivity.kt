package com.example.mainscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.core.App
import com.example.core.actions.ShowNewFilmsAction
import com.example.mainscreen.di.component.MainActivityComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var showNewFilmsAction: ShowNewFilmsAction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    private fun inject() {
        MainActivityComponent.Initializer
            .init((applicationContext as App).getAppComponent())
            .inject(this@MainActivity)
    }

}