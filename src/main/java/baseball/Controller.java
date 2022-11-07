package baseball;

import baseball.Game.Number;
public class Controller {
    final int NUM_LEN = 3;
    final int MIN_NUM = 1;
    final int MAX_NUM = 9;

    public void run() {
        setGame();
        startGame();
        endGame();
    }

    private void setGame() {
        Number number = new Number();
        int randomNum = number.getRandomNum(NUM_LEN, MIN_NUM, MAX_NUM);
    }

    private void startGame() {

    }

    private void endGame() {

    }
}
