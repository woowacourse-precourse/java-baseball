package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameInteractor {
    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static GameNumbers promptUserForNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();

        return GameNumbers.fromString(input);
    }

    public static void printGuessResult(GuessResult gr) {
        System.out.println(gr.toSpecString());
    }

    public static void printGameFinishedBySuccess() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static boolean promptUserForGameRestart() {
        final String RESTART_TRUE = "1";
        final String RESTART_FALSE = "2";

        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
                          RESTART_TRUE,
                          RESTART_FALSE);

        String input = Console.readLine();

        if (input.equals(RESTART_TRUE)) {
            return true;
        }
        if (input.equals(RESTART_FALSE)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}