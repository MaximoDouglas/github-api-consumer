package com.maximo.douglas.githubconsumer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.argmax.githubconsumer.R

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

}