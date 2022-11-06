package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;

public class GameService {
    private Computer computer;
    private User user;
    private int strike, ball;

    public GameService() {
    }

    private void initGame() {
        computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void doTurn() throws IllegalArgumentException {
        strike = 0;
        ball = 0;
    }
}
