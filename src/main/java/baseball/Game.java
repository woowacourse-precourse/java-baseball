package baseball;

import java.util.List;

public class Game {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void run() {
        int strike = -1;
        List<Integer> opponent = Number.getOpponentNumbersInList();

        while (strike != Number.NUMBERS_SIZE) {
            System.out.print(ENTER_NUMBER_MESSAGE);
            List<Integer> user = Number.getUserNumbersInList();
            printUserNumber(user);

            int ball = Count.Ball(opponent, user);
            strike = Count.Strike(opponent, user);
            printHint(strike, ball);
        }
    }

    public static void printUserNumber(List<Integer> user) {
        StringBuilder userNumber = new StringBuilder();
        for (int num : user) {
            userNumber.append(num);
        }
        System.out.println(userNumber);
    }

    public static void printHint(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING_MESSAGE);
        }
        if (strike == 0 && ball > 0) {
            printBall(ball);
        }
        if (strike > 0 && ball == 0) {
            printStrike(strike);
        }
        if (strike > 0 && ball > 0) {
            printStrikeBall(strike, ball);
        }
    }

    public static void printBall(int ball) {
        System.out.println(ball + BALL_MESSAGE);
    }

    public static void printStrike(int strike) {
        System.out.println(strike + STRIKE_MESSAGE);
    }

    public static void printStrikeBall(int strike, int ball) {
        System.out.print(ball + BALL_MESSAGE + " ");
        System.out.println(strike + STRIKE_MESSAGE);
    }
}