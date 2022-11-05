package baseball;

import baseball.game.NumberBaseBall;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberBaseBall numberBaseBall = new NumberBaseBall();
        while (!numberBaseBall.isEndGame()) {
            numberBaseBall.start();
            while (!numberBaseBall.isStopGame()) {
                numberBaseBall.play();
            }
            numberBaseBall.end();
        }
    }
}
