package baseball.service;

import baseball.domain.Computer;

public class GameService {
    private static Computer computer;

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer = new Computer();
    }
}
