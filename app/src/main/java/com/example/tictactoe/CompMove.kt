package com.example.tictactoe

import java.util.*
import kotlin.collections.ArrayList

fun getComputerMove(board: ArrayList<String>): Int {

    //check if computer can win in this move
    for (i in 0 until board.count()) {
        val copy = getBoardCopy(board)
        if (copy[i] == "") {
            copy[i] = "O"
            if (isGameOver(copy, "O"))
                return i
        }
    }

    //check if player could win in the next move
    for (i in 0 until board.count()) {
        val copy2 = getBoardCopy(board)
        if (copy2[i] == "") {
            copy2[i] = "X"
            if (isGameOver(copy2, "X"))
                return i
        }
    }

    //try to take corners if its free
    val move = choseRandomMove(board, arrayListOf(0, 2, 6, 8))
    if (move != -1)
        return move

    //try to take center if its free
    if (board[4] == "") return 4

    //move on one of the sides
    return choseRandomMove(board, arrayListOf(1, 3, 5, 7))
}

fun choseRandomMove(board: ArrayList<String>, list: ArrayList<Int>): Int {
    val possibleMoves =
            list.filter { board[it] == "" }
    return if (possibleMoves.isEmpty()) -1
    else {
        val index = Random().nextInt(possibleMoves.count())
        possibleMoves[index]
    }
}

fun getBoardCopy(board: ArrayList<String>) =
        ArrayList(board.toList())

fun isBoardFull(board: ArrayList<String>) =
    board.none { i -> i != "X" && i != "O" }

fun isGameOver(bd: ArrayList<String>, s: String): Boolean =
    if(bd[0] == s && bd[1] == s && bd[2] == s) true
    else if(bd[3] == s && bd[4] == s && bd[5] == s) true
    else if(bd[6] == s && bd[7] == s && bd[8] == s) true
    else if(bd[0] == s && bd[3] == s && bd[6] == s) true
    else if(bd[1] == s && bd[4] == s && bd[7] == s) true
    else if(bd[2] == s && bd[5] == s && bd[8] == s) true
    else if(bd[0] == s && bd[4] == s && bd[8] == s) true
    else bd[2] == s && bd[4] == s && bd[6] == s