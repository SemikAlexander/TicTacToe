package com.example.tictactoe

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val pref = getSharedPreferences("setting", Context.MODE_PRIVATE)
        if (pref.getString("mode", null).toString() == "dark")
            setTheme(R.style.Theme_TicTacToeNight)
        else
            setTheme(R.style.Theme_TicTacToe)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            singleGameButton.setOnClickListener {
                startActivity(Intent(this@MenuActivity, GameActivity::class.java).putExtra("game_mode", "single"))//startActivity<SingleplayerActivity>()
            }

            multiplayerGameButton.setOnClickListener {
                startActivity(Intent(this@MenuActivity, GameActivity::class.java).putExtra("game_mode", "multi"))
            }

            settingsButton.setOnClickListener {
                startActivity<SettingsActivity>()
                finish()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}