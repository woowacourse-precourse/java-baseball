package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean gamingMode = true;
        NumberBaseBall Game = new NumberBaseBall();
        do {
            List<Integer> computerNumberList = Computer.generateRandomNum();
            gamingMode = Game.GameStart(computerNumberList);
        } while (gamingMode);
    }
}
