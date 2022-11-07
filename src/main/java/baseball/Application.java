package baseball;

import baseball.controller.BaseballSystem;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballSystem system = new BaseballSystem();
        system.runGame();
    }
}