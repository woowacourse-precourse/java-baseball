package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PrintAndRead {

    public static void firstStartPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> getBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String question = Console.readLine();

        return convertToIntegerList(question);
    }

    public static List<Integer> convertToIntegerList(String question) {
        String[] splitQuestion = question.split("");

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < question.length(); i++) {
            result.add(Integer.parseInt(splitQuestion[i]));
        }

        return result;
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printBallOrStrike(int ball, int strike) {
        if (strike == 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }

        if (ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }

    public static int printRestartGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = Console.readLine();

        return Integer.parseInt(answer);
    }

}
