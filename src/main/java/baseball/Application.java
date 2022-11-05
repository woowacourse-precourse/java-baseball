package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Baseball baseball = new Baseball();
        Computer computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            ArrayList<String> computerBall = computer.createNumber();
            baseball.play(computerBall);
        } while (baseball.restart());
    }
}