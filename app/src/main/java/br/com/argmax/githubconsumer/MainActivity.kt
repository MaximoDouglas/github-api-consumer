package br.com.argmax.githubconsumer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.argmax.githubconsumer.ui.di.MainComponent

open class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainComponent =
            (applicationContext as GithubConsumerApp).applicationComponent.mainComponent().create()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

}