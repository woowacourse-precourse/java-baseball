package baseball;

import baseball.computer.Controller;
import baseball.Message;

import java.util.List;

public class BaseballGame {
    private static final int RE_GAME = 1;
    private static final int STOP_GAME = 2;
    private final Message message = new Message();

    public void play() {
        message.printStartMessage();
        do {
            runGame();
        } while (true);
    }

    public void runGame() {
        List<Integer> balls = new Controller().getBalls();
        do {
            message.printInputMessage();
            //값 받아오기
            //값 비교
        } while (true);
    }
}
