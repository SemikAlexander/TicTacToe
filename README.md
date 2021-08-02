# TicTacToe
Tic-tac-toe is a logical game between two opponents on a square field of 3 by 3 squares or larger (up to "infinite field"). One of the players plays "crosses", the second - "zeros". The traditional Chinese game (Gomoku) uses black and white stones.

#### Rules of the game

Winning a game of tic-tac-toe
Players take turns putting signs (one always crosses, the other always zeros) on free cells of a 3×3 field. The first one to line up 3 of his pieces vertically, horizontally or diagonally wins. The first move is made by the player putting crosses.

Usually at the end of the game the winning side crosses out its three marks (zeros and crosses) making a continuous row.

#### Analysis

For each side, algorithms are generally known that guarantee a draw for any opponent's play, and that if the opponent makes a mistake, he can win. Thus, the game is in a state of "draw death."

Below are some of these strategies. A player is always considered to follow two rules that take precedence over all others:

Rule 1. If a player can win immediately, he does so.
Rule 2. If the player cannot win immediately, but his opponent could win immediately by making a move to a particular square, the player himself makes a move to that square, preventing an immediate loss.
