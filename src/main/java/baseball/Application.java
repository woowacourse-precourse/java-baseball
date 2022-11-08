package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static boolean isSystemOn = true;

    public static void main(String[] args) {
        boolean checkPlayGame = true;

        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (checkPlayGame) {
            // 게임 시작
            try {
                game.startGame();
            }
            catch (IllegalArgumentException e) {
               throw new IllegalArgumentException();
            }

            // 게임 종료 조건 확인
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String restartCheckNum = Console.readLine();
            System.out.println(restartCheckNum);
            if (restartCheckNum.equals("2")) {
                checkPlayGame = false;
            }
            if (restartCheckNum.equals("1")) {
                continue;
            }

            // 그 외의 숫자를 입력했을 때
            break;
        }
    }
}
