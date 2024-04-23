## Requirement

- The game board has a size of n x n, where n is a positive integer.
- The number of players in the game is n-1. For example, if the board size is 3x3, there will be 2 players.
- Players can choose their own symbols to represent their moves on the board.
- The game can include a computer-controlled bot player.
- There can be only one bot player per game.
- The order in which players take their turns is randomized at the start of each game.
- A player wins when they successfully place their symbols in a complete row, column, or diagonal on the board.
- If all cells on the board are filled, and no player has a winning row, column, or diagonal, the game ends in a draw.
- The game should have a replay feature that allows players to undo their previous moves using a stack data structure.

## Diagram

```java

class Game{
  Board board;
  List<Player> players;
  int nextPlayerMove;
  boolean winner;
  GameState state;
}

class Move {
  Cell cell;
  Player player;
}

enum GameState {
  INPROGRESS,
  ENDED,
  DRAW
}

class Board{
  int size;
  List<List<Cell>> board;
  int players;
  boolean bot;
}

class Cell {
  int row;
  int col;
  Player whoseMove;
  CellState state;
}

enum CellState {
  EMPTY,
  FILLED,
  BLOCKED
}
class Player{
  int id;
  Symbol symbol;
  boolean isWinner;
  PlayerType type;
}

enum PlayerType {
  HUMAN,
  BOT
}

class Symbol{
  char sym;
}

class Bot extends Player {
  Difficulty level;
}

enum Difficulty {
  EASY,
  MEDIUM,
  HARD,
  EXTREME
}
