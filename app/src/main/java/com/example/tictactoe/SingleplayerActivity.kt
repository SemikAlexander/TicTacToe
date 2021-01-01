package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivitySingleplayerBinding

class SingleplayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingleplayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singleplayer)

        binding = ActivitySingleplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var userWin = 0
        var compWin = 0

        var board = arrayListOf("", "", "", "", "", "", "", "", "")

        binding.apply {
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
                    userWin++
                    scoreTable.text = "$userWin : $compWin"

                    clearBoard()
                    startActivity(Intent(this@SingleplayerActivity, ResultActivity::class.java).putExtra("won_game", "YOU"))
                }else if(result(board, "O")){
                    compWin++
                    scoreTable.text = "$userWin : $compWin"

                    clearBoard()
                    startActivity(Intent(this@SingleplayerActivity, ResultActivity::class.java).putExtra("won_game", "COMPUTER"))
                }
                if(isBoardFull(board)){
                    userWin++
                    compWin++
                    scoreTable.text = "$userWin : $compWin"

                    clearBoard()
                    startActivity(Intent(this@SingleplayerActivity, ResultActivity::class.java).putExtra("won_game", "TIE"))
                }
            }
            button1.setOnClickListener {
                if (board[0] == ""){
                    board[0] = "X"
                    button1.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
            button2.setOnClickListener {
                if (board[1] == ""){
                    board[1] = "X"
                    button2.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
            button3.setOnClickListener {
                if (board[2] == "") {
                    board[2] = "X"
                    button3.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
            button4.setOnClickListener {
                if (board[3] == ""){
                    board[3] = "X"
                    button4.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
            button5.setOnClickListener {
                if (board[4] == "") {
                    board[4] = "X"
                    button5.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
            button6.setOnClickListener {
                if (board[5] == "") {
                    board[5] = "X"
                    button6.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
            button7.setOnClickListener {
                if (board[6] == "") {
                    board[6] = "X"
                    button7.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
            button8.setOnClickListener {
                if (board[7] == "") {
                    board[7] = "X"
                    button8.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
            button9.setOnClickListener {
                if (board[8] == "") {
                    board[8] = "X"
                    button9.setImageResource(R.mipmap.tic)
                    if (!isBoardFull(board) && !result(board, "X")) {
                        val pos = getComputerMove(board)
                        board[pos] = "O"
                        drawCompMove(pos)
                    }
                }
                resultOut(board)
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}