package game.stdiogame.numberbaseball;

import game.GameStatus;
import game.stdiogame.SimpleStdIOGame;

public class NumberBaseballStdIOGame extends SimpleStdIOGame {
    public NumberBaseballStdIOGame(String name, GameStatus gameStatus) {
        super(name, gameStatus);
    }

    @Override
    public void start() {
        GameStatus gameStatus = getGameStatus();
        gameStatus.setStart(true);
    }

    @Override
    public void loop() {
        loopGame();
    }

    @Override
    public void finish() {

    }

    @Override
    protected void writeGameMessage() {

    }

    @Override
    protected void readInput() {

    }

    @Override
    protected void checkInput() throws IllegalArgumentException {

    }

    @Override
    public void operateRule() {

    }

    @Override
    protected void writeOutput() {

    }

    private void countBall() {

    }

    private void countStrike() {

    }

    private void prepareOutputData() {

    }

}
