package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.tictactoe.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val pref = getSharedPreferences("setting", Context.MODE_PRIVATE)
        if (pref.getString("mode", null).toString() == "dark")
            setTheme(R.style.Theme_TicTacToeNight)
        else
            setTheme(R.style.Theme_TicTacToe)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var move = "X"

        var xUser = 0
        var oUser = 0

        var board = arrayListOf("", "", "", "", "", "", "", "", "")

        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val field = listOf(
                    button1, button2,  button3,
                    button4, button5, button6,
                    button7, button8, button9
            )

            var isSinglePlayer = false

            if (intent.getStringExtra("game_mode") == "single") isSinglePlayer = true

            fun drawCompMove(pos: Int) = field[pos].setImageResource(R.drawable.circle)

            fun clearBoard() {
                field.forEach { it.setImageDrawable(null) }
                board = arrayListOf("", "", "", "", "", "", "", "", "")
            }

            @SuppressLint("SetTextI18n")
            fun resultOut(board: ArrayList<String>) {
                if (isGameOver(board, "X")) {
                    xUser++
                    scoreTable.text = "$xUser : $oUser"

                    clearBoard()

                    startActivity<ResultActivity> {
                        putExtra("won_game", if (isSinglePlayer) "YOU" else "X")
                    }
                } else if (isGameOver(board, "O")) {
                    oUser++
                    scoreTable.text = "$xUser : $oUser"

                    clearBoard()

                    startActivity<ResultActivity> {
                        putExtra("won_game", if (isSinglePlayer) "COMPUTER" else "O")
                    }
                }
                if (isBoardFull(board)) {
                    xUser++
                    oUser++
                    scoreTable.text = "$xUser : $oUser"

                    clearBoard()

                    startActivity<ResultActivity> {
                        putExtra("won_game", "TIE")
                    }
                }
            }

            fun doSingleModeAction(index: Int, button: ImageButton) {
                if (board[index] == "") {
                    board[index] = "X"
                    button.setImageResource(R.drawable.tic)
                    if (!isBoardFull(board) && !isGameOver(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }

            fun doMultiplayerModeAction(index: Int, button: ImageButton) {
                if (move == "X") {
                    if (board[index] == "") {
                        board[index] = "X"
                        button.setImageResource(R.drawable.tic)
                        if (!isBoardFull(board) && !isGameOver(board, "X")) move = "O"
                    }
                    resultOut(board)
                } else {
                    if (board[index] == "") {
                        board[index] = "O"
                        button.setImageResource(R.drawable.circle)
                        if (!isBoardFull(board) && !isGameOver(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }

            field.indices.forEach { i ->
                field[i].setOnClickListener {
                    if (isSinglePlayer)
                        doSingleModeAction(i, field[i])
                    else
                        doMultiplayerModeAction(i, field[i])
                }
            }
        }
    }
}