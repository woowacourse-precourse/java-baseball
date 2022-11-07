package game.stdiogame;

import game.Game;
import game.GameStatus;

public abstract class SimpleStdIOGame implements Game {
    private final String name;
    private final GameStatus gameStatus;

    public SimpleStdIOGame(String name, GameStatus gameStatus) {
        this.name = name;
        this.gameStatus = gameStatus;
    }

    protected abstract void writeGameMessage();
    protected abstract void readInput();
    protected abstract void checkInput() throws IllegalArgumentException;
    public abstract void operateRule();
    protected abstract void writeOutput();

    private boolean isFinish() {
        return getGameStatus().isFinish();
    }

    private boolean isStart() { return getGameStatus().isStart(); }

    protected void loopGame() {
        writeGameMessage();
        while (!isFinish()) {
            readInput();
            checkInput();
            operateRule();
            writeOutput();
        }
        writeGameMessage();
    }

    public String getName() {
        return name;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
