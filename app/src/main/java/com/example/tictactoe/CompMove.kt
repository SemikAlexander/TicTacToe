package com.example.tictactoe

import java.util.*
import kotlin.collections.ArrayList

public fun getComputerMove(board: ArrayList<String>): Int {

    //check if computer can win in this move
    for (i in 0 until board.count()){
        var copy: ArrayList<String> = getBoardCopy(board)
        if(copy[i] == "") {
            copy[i] = "O"
            if (result(copy, "O"))
                return i
        }
    }

    //check if player could win in the next move
    for (i in 0 until board.count()){
        var copy2 = getBoardCopy(board)
        if(copy2[i] == "") {
            copy2[i] = "X"
            if (result(copy2, "X"))
                return i
        }
    }

    //try to take corners if its free
    var move = choseRandomMove(board, arrayListOf<Int>(0, 2, 6, 8))
    if(move != -1)
        return move

    //try to take center if its free
    if(board[4] == "") return 4

    //move on one of the sides
    return choseRandomMove(board, arrayListOf<Int>(1, 3, 5, 7))
}


public fun choseRandomMove(board: ArrayList<String>, list: ArrayList<Int>): Int {
    var possibleMoves = arrayListOf<Int>()
    for (i in list){
        if(board[i] == "") possibleMoves.add(i)
    }
    if(possibleMoves.isEmpty()) return -1
    else {
        var index = Random().nextInt(possibleMoves.count())
        return possibleMoves[index]
    }
}

public fun getBoardCopy(board: ArrayList<String>): ArrayList<String> {
    var bd = arrayListOf<String>("", "", "", "", "", "", "", "", "")
    for (i in 0 until board.count()) {
        bd[i] = board[i]
    }
    return bd
}

public fun isBoardFull(board: ArrayList<String>): Boolean {
    for (i in board)
        if(i != "X" && i != "O")
            return false
    return true
}

public fun result(bd: ArrayList<String>, s: String): Boolean =
    if(bd[0] == s && bd[1] == s && bd[2] == s) true
    else if(bd[3] == s && bd[4] == s && bd[5] == s) true
    else if(bd[6] == s && bd[7] == s && bd[8] == s) true
    else if(bd[0] == s && bd[3] == s && bd[6] == s) true
    else if(bd[1] == s && bd[4] == s && bd[7] == s) true
    else if(bd[2] == s && bd[5] == s && bd[8] == s) true
    else if(bd[0] == s && bd[4] == s && bd[8] == s) true
    else bd[2] == s && bd[4] == s && bd[6] == s