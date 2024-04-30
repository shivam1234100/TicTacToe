package shivam24.tictactoe.models;

import shivam24.tictactoe.exceptions.InvalidMoveException;
import shivam24.tictactoe.strategies.WinStrategy;

import java.util.List;
import java.util.ArrayList;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextToPlay;
    private Player winnner;
    private List<Move> moves;
    private GameState gameState;
    WinStrategy winStrategy;

    public Game(int size, List<Player> players) {
        this.board = new Board(size);
        this.players = players;
        this.nextToPlay = 0;
        this.winnner = null;
        this.moves = new ArrayList<>();
        this.gameState = GameState.PROGRESS;
        this.winStrategy = new WinStrategy();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getNextPlayerMoveIndex() {
        return nextToPlay;
    }

    public void setNextPlayerMoveIndex(int nextToPlay) {
        this.nextToPlay = nextToPlay;
    }

    public Player getWinner() {
        return winnner;
    }

    public void setWinner(Player winner) {
        winnner = winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if (row < 0 || row >= this.board.getSize() || col < 0 || col >= this.board.getSize()) {
            return false;
        }
        return board.getBoard().get(row).get(col).getState().equals(CellState.EMPTY);
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = this.players.get(this.nextToPlay);
        System.out.println(currentPlayer.getName() + "'s turn.");

        Move move = currentPlayer.makeMove(this.board);

        if (!validateMove(move)) {
            throw new InvalidMoveException(currentPlayer.getName() + " has made an invalid move.");
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellToChange = this.board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setState(CellState.FILLED);

        Move finalMove = new Move(cellToChange, currentPlayer);
        this.moves.add(finalMove);
        nextToPlay = (nextToPlay + 1) % this.players.size();

        if (winStrategy.checkWinner(board, finalMove)) {
            this.gameState = GameState.ENDED;
            this.winnner = currentPlayer;
        }
    }
}
