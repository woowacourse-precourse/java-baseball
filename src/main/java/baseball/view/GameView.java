package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ONLY_STRIKE_MESSAGE = "%d스트라이크\n";
    private static final String ONLY_BALL_MESSAGE = "%d볼\n";
    private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printStartMessage() {
        System.out.print(START_MESSAGE);
    }

    public static String askUserInput() {
        System.out.print(ASK_USER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static void printHint(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (strikeCount >= 0 && ballCount == 0) {
            System.out.printf(ONLY_STRIKE_MESSAGE, strikeCount);
            return;
        }
        if (strikeCount == 0 && ballCount >= 0) {
            System.out.printf(ONLY_BALL_MESSAGE, ballCount);
            return;
        }
        System.out.printf(BALL_AND_STRIKE_MESSAGE, ballCount, strikeCount);
    }

    public static String askRestart() {
        System.out.println(ASK_RESTART_MESSAGE);
        return Console.readLine();
    }

    public static void printResult(boolean correct) {
        if (correct) {
            System.out.println(FINISH_MESSAGE);
        }
    }
}
