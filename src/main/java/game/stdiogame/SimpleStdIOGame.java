package game.stdiogame;

import game.Game;
import game.GameStatus;

public abstract class SimpleStdIOGame extends Game {
    public SimpleStdIOGame(String name, GameStatus gameStatus) {
        super(name, gameStatus);
    }

    protected abstract void writeGameMessage();
    protected abstract void readInput();
    protected abstract void checkInput() throws IllegalArgumentException;
    public abstract void operateRule();
    protected abstract void writeOutput();

    private boolean isFinish() {
        return getGameStatus().isFinish();
    }

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
}
