package com.nirux.prntscrn.randomizer

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.webkit.WebView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.nirux.prntscrn.randomizer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val disclaimer = "Warning: This randomizes snippets, you might see something unintended."
    val nsfw_disclaimer = "NSFW WARNING - You've been warned."

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideStatusBar()
        DisclaimerPopUp()
        NSFWDisclaimerPopUp()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        webView()
    }

    fun webView() {
        val myWebView = WebView(nav_view)
        setContentView(myWebView)
        myWebView.loadUrl("http://www.example.com")
    }

    fun DisclaimerPopUp() {
        val text = disclaimer
        val duration = Toast.LENGTH_LONG

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun NSFWDisclaimerPopUp() {
        val text = nsfw_disclaimer
        val duration = Toast.LENGTH_LONG

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }
}