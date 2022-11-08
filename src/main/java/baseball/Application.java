package baseball;

import baseball.domain.Computer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다");
        computer.playGame();
    }
}
