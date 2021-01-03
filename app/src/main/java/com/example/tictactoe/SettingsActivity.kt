package com.example.tictactoe

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private val preference by lazy {
        PreferenceManager.getDefaultSharedPreferences(this)
    }

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val pref = getSharedPreferences("setting", Context.MODE_PRIVATE)
        if (pref.getString("mode", null).toString() == "dark")
            setTheme(R.style.Theme_TicTacToeNight)
        else
            setTheme(R.style.Theme_TicTacToe)

        val editor = pref.edit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            if (pref.getString("mode", null).toString() == "dark"){
                darkMode.isChecked = true
                darkMode.setThumbResource(R.mipmap.moon)
            }

            darkMode.setOnCheckedChangeListener { _, isChecked ->
                when {
                    isChecked -> {
                        darkMode.setThumbResource(R.mipmap.moon)
                        editor.putString("mode", "dark")
                    }
                    else -> {
                        darkMode.setThumbResource(R.mipmap.sun)
                        editor.putString("mode", "day")
                    }
                }
                editor.apply()
                startActivity<SettingsActivity>()
                finish()
            }

            saveButton.setOnClickListener {
                /*startActivity<SplashActivity>()
                finish()
                finishAffinity()*/
            }
        }
    }

    override fun onBackPressed() {
        startActivity<MenuActivity>()
        finish()
    }
}