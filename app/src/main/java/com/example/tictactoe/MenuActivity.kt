package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            singleGameButton.setOnClickListener {
                startActivity<SingleplayerActivity>()
            }

            multiplayerGameButton.setOnClickListener {
                startActivity<MultiplayerActivity>()
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}