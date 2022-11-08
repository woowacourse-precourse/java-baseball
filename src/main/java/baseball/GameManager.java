package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        onGame();
    }

    static void onGame() {
        List<Integer> computer = Computer.createNewValue();

        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            // 입력 예외처리
            List<Integer> compareResult = Computer.compareWithInput(input, computer);
            String compareResultString = Computer.resultToString(compareResult);
            System.out.println(compareResultString);

            if (compareResultString.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        afterGame();
    }

    static void afterGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            onGame();
        }
        if (input.equals("2")) {
            return;
        }
        // 입력 예외처리
    }
}
