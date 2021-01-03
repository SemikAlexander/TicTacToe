package com.example.tictactoe

import android.content.Context
import android.content.Intent
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

        var X_User = 0
        var O_User = 0

        var board = arrayListOf("", "", "", "", "", "", "", "", "")

        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            var isSinglePlayer = false
            if(intent.getStringExtra("game_mode") == "single") isSinglePlayer = true

            fun drawCompMove(pos: Int){
                when (pos) {
                    0 -> button1.setImageResource(R.mipmap.circle)
                    1 -> button2.setImageResource(R.mipmap.circle)
                    2 -> button3.setImageResource(R.mipmap.circle)
                    3 -> button4.setImageResource(R.mipmap.circle)
                    4 -> button5.setImageResource(R.mipmap.circle)
                    5 -> button6.setImageResource(R.mipmap.circle)
                    6 -> button7.setImageResource(R.mipmap.circle)
                    7 -> button8.setImageResource(R.mipmap.circle)
                    8 -> button9.setImageResource(R.mipmap.circle)
                }
            }
            fun clearBoard(){
                button1.setImageDrawable(null)
                button2.setImageDrawable(null)
                button3.setImageDrawable(null)
                button4.setImageDrawable(null)
                button5.setImageDrawable(null)
                button6.setImageDrawable(null)
                button7.setImageDrawable(null)
                button8.setImageDrawable(null)
                button9.setImageDrawable(null)
                board = arrayListOf("", "", "", "", "", "", "", "", "")
            }
            fun resultOut(board: ArrayList<String>){
                if(result(board, "X")){
                    X_User++
                    scoreTable.text = "$X_User : $O_User"

                    clearBoard()
                    when {
                        isSinglePlayer -> startActivity(Intent(this@GameActivity, ResultActivity::class.java).putExtra("won_game", "YOU"))
                        else -> startActivity(Intent(this@GameActivity, ResultActivity::class.java).putExtra("won_game", "X"))
                    }
                }
                else if(result(board, "O")){
                    O_User++
                    scoreTable.text = "$X_User : $O_User"

                    clearBoard()
                    if (isSinglePlayer)
                        startActivity(Intent(this@GameActivity, ResultActivity::class.java).putExtra("won_game", "COMPUTER"))
                    else
                        startActivity(Intent(this@GameActivity, ResultActivity::class.java).putExtra("won_game", "O"))
                }
                if(isBoardFull(board)){
                    X_User++
                    O_User++
                    scoreTable.text = "$X_User : $O_User"

                    clearBoard()
                    startActivity(Intent(this@GameActivity, ResultActivity::class.java).putExtra("won_game", "TIE"))
                }
            }
            fun doSingleModeAction(index: Int, button: ImageButton){
                if (board[index] == ""){
                    board[index] = "X"
                    button.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
            fun doMultiplayerModeAction(index: Int, button: ImageButton){
                if (move == "X"){
                    if (board[index] == ""){
                        board[index] = "X"
                        button.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[index] == ""){
                        board[index] = "O"
                        button.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }

            button1.setOnClickListener {
                if (isSinglePlayer)
                    doSingleModeAction(0, button1)
                else
                    doMultiplayerModeAction(0, button1)
            }
            button2.setOnClickListener {
                if (isSinglePlayer)
                    doSingleModeAction(1, button2)
                else
                    doMultiplayerModeAction(1, button2)
            }
            button3.setOnClickListener {
                if (isSinglePlayer)
                    doSingleModeAction(2, button3)
                else
                    doMultiplayerModeAction(2, button3)
            }
            button4.setOnClickListener {
                if (isSinglePlayer)
                    doSingleModeAction(3, button4)
                else
                    doMultiplayerModeAction(3, button4)
            }
            button5.setOnClickListener {
                if (isSinglePlayer)
                    doSingleModeAction(4, button5)
                else
                    doMultiplayerModeAction(4, button5)
            }
            button6.setOnClickListener {
                if (isSinglePlayer)
                    doSingleModeAction(5, button6)
                else
                    doMultiplayerModeAction(5, button6)
            }
            button7.setOnClickListener {
                if (isSinglePlayer)
                    doSingleModeAction(6, button7)
                else
                    doMultiplayerModeAction(6, button7)
            }
            button8.setOnClickListener {
                if (isSinglePlayer)
                    doSingleModeAction(7, button8)
                else
                    doMultiplayerModeAction(7, button8)
            }
            button9.setOnClickListener {
                if (isSinglePlayer)
                    doSingleModeAction(8, button9)
                else
                    doMultiplayerModeAction(8, button9)
            }
        }
    }
}