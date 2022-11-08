package baseball;

import baseball.gamebody.EntireProgram;

public class Application {
    public static void main(String[] args) {
        EntireProgram game = new EntireProgram();
        System.out.println("숫자 야구 게임을 시작합니다.");
        game.baseballGame();
    }
}
