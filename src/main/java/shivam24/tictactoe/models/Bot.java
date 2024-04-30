package shivam24.tictactoe.models;

import java.util.List;

public class Bot extends Player {
    private BotLevel botlevel;

    public Bot(String name, Symbol symbol, BotLevel botlevel) {
        super(name, symbol, PlayerType.BOT);
        this.botlevel = botlevel;
    }

    public BotLevel getBotLevel() {
        return botlevel;
    }

    public void setBotLevel(BotLevel botlevel) {
        this.botlevel = botlevel;
    }

    public Move makeMove(Board board) {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getState().equals(CellState.EMPTY)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
