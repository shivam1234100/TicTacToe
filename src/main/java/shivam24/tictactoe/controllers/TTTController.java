package shivam24.tictactoe.controllers;

import shivam24.tictactoe.exceptions.InvalidMoveException;
import shivam24.tictactoe.models.Game;
import shivam24.tictactoe.models.GameState;
import shivam24.tictactoe.models.Player;
import java.util.List;

public class TTTController {
    public Game startGame(int size, List<Player> players) {
        return new Game(size, players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}
