package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static boolean playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        return true;
    }

    public static boolean restartGame() {

        int answer;

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        answer = Integer.parseInt(Console.readLine());

        if (answer == 1) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        boolean status = playGame();

        while (status != false) {

        }

    }

}
