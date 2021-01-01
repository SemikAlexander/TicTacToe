package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.databinding.ActivityMultiplayerBinding

class MultiplayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMultiplayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplayer)

        var move = "X"

        var X_User = 0
        var O_User = 0

        var board = arrayListOf("", "", "", "", "", "", "", "", "")

        binding = ActivityMultiplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
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
                    startActivity(Intent(this@MultiplayerActivity, ResultActivity::class.java).putExtra("won_game", "X"))
                }
                else if(result(board, "O")){
                    O_User++
                    scoreTable.text = "$X_User : $O_User"

                    clearBoard()
                    startActivity(Intent(this@MultiplayerActivity, ResultActivity::class.java).putExtra("won_game", "O"))
                }
                if(isBoardFull(board)){
                    X_User++
                    O_User++
                    scoreTable.text = "$X_User : $O_User"

                    clearBoard()
                    startActivity(Intent(this@MultiplayerActivity, ResultActivity::class.java).putExtra("won_game", "TIE"))
                }
            }

            button1.setOnClickListener {
                if (move == "X"){
                    if (board[0] == ""){
                        board[0] = "X"
                        button1.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[0] == ""){
                        board[0] = "O"
                        button1.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }
            button2.setOnClickListener {
                if (move == "X"){
                    if (board[1] == ""){
                        board[1] = "X"
                        button2.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[1] == ""){
                        board[1] = "O"
                        button2.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }
            button3.setOnClickListener {
                if (move == "X"){
                    if (board[2] == ""){
                        board[2] = "X"
                        button3.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[2] == ""){
                        board[2] = "O"
                        button3.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }
            button4.setOnClickListener {
                if (move == "X"){
                    if (board[3] == ""){
                        board[3] = "X"
                        button4.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[3] == ""){
                        board[3] = "O"
                        button4.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }
            button5.setOnClickListener {
                if (move == "X"){
                    if (board[4] == ""){
                        board[4] = "X"
                        button5.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[4] == ""){
                        board[4] = "O"
                        button5.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }
            button6.setOnClickListener {
                if (move == "X"){
                    if (board[5] == ""){
                        board[5] = "X"
                        button6.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[5] == ""){
                        board[5] = "O"
                        button6.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }
            button7.setOnClickListener {
                if (move == "X"){
                    if (board[6] == ""){
                        board[6] = "X"
                        button7.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[6] == ""){
                        board[6] = "O"
                        button7.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }
            button8.setOnClickListener {
                if (move == "X"){
                    if (board[7] == ""){
                        board[7] = "X"
                        button8.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[7] == ""){
                        board[7] = "O"
                        button8.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }
            button9.setOnClickListener {
                if (move == "X"){
                    if (board[8] == ""){
                        board[8] = "X"
                        button9.setImageResource(R.mipmap.tic)
                        if (!isBoardFull(board) && !result(board, "X")) move = "O"
                    }
                    resultOut(board)
                }
                else{
                    if (board[8] == ""){
                        board[8] = "O"
                        button9.setImageResource(R.mipmap.circle)
                        if (!isBoardFull(board) && !result(board, "0")) move = "X"
                    }
                    resultOut(board)
                }
            }
        }
    }
}