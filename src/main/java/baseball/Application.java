package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        do {
            Game.playGame();
        } while (restartGame());
    }
    public static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String s = Console.readLine();
        if (s.equals("1")) {
            return true;
        } else if (s.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("not 1,2: input erroooor");
        }
    }
}
