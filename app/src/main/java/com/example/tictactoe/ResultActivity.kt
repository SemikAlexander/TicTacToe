package com.example.tictactoe

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityResultBinding

class ResultActivity : Activity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val pref = getSharedPreferences("setting", Context.MODE_PRIVATE)
        if (pref.getString("mode", null).toString() == "dark")
            setTheme(R.style.Theme_TicTacToeNight)
        else
            setTheme(R.style.Theme_TicTacToe)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            when (intent.getStringExtra("won_game")) {
                "YOU" -> {
                    resultTextView.text = getString(R.string.win_game_string)
                    resultImageView.setImageResource(R.mipmap.won)
                }
                "COMPUTER" -> {
                    resultTextView.text = getString(R.string.lose_game_string)
                    resultImageView.setImageResource(R.mipmap.lost)
                }
                "X" -> {
                    resultTextView.text = getString(R.string.x_player_win_game)
                    resultImageView.setImageResource(R.mipmap.won)
                }
                "O" -> {
                    resultTextView.text = getString(R.string.o_player_win)
                    resultImageView.setImageResource(R.mipmap.won)
                }
                else -> {
                    resultTextView.text = getString(R.string.draw_game_string)
                    resultImageView.setImageResource(R.mipmap.draw)
                }
            }

            playAgainButton.setOnClickListener {
                finish()
            }
        }
    }
}