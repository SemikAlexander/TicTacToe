package com.example.tictactoe

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.tictactoe.databinding.ActivityResultBinding
import java.util.*

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

        pref.getString("language", null)?.apply {
            setLocale(this@ResultActivity, this)
        }

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            when (intent.getStringExtra("won_game")) {
                "YOU" -> {
                    resultTextView.text = getString(R.string.win_game_string)
                    resultImageView.setImageResource(R.drawable.won)
                }
                "COMPUTER" -> {
                    resultTextView.text = getString(R.string.lose_game_string)
                    resultImageView.setImageResource(R.drawable.lost)
                }
                "X" -> {
                    resultTextView.text = getString(R.string.x_player_win_game)
                    resultImageView.setImageResource(R.drawable.won)
                }
                "O" -> {
                    resultTextView.text = getString(R.string.o_player_win)
                    resultImageView.setImageResource(R.drawable.won)
                }
                else -> {
                    resultTextView.text = getString(R.string.draw_game_string)
                    resultImageView.setImageResource(R.drawable.draw)
                }
            }

            playAgainButton.setOnClickListener {
                finish()
            }
        }
    }

    private fun setLocale(context: Context, locale: String) {
        context.resources.configuration.locale = Locale(locale)
        context.resources.updateConfiguration(
                context.resources.configuration,
                context.resources.displayMetrics
        )
    }
}