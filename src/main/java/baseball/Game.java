package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART = "1";
    private static final String GAME_OVER = "2";

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
        askRestart();
    }

    public static void printUserNumber(List<Integer> user) {
        StringBuilder userNumber = new StringBuilder();
        for (int num : user) {
            userNumber.append(num);
        }
        System.out.println(userNumber);
    }

    public static void printHint(int strike, int ball) {
        validateStrikeBall(strike, ball);
        if (strike == 0 && ball == 0) {
            System.out.println(Hint.NOTHING.message());
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

    public static void validateStrikeBall(int strike, int ball) {
        if (strike + ball > Number.NUMBERS_SIZE) {
            throw new IllegalArgumentException("The number of strikes and balls is outside the allowed range.");
        }
    }

    public static void printBall(int ball) {
        System.out.print(ball);
        System.out.println(Hint.BALL.message());
    }

    public static void printStrike(int strike) {
        System.out.print(strike);
        System.out.println(Hint.STRIKE.message());
    }

    public static void printStrikeBall(int strike, int ball) {
        System.out.print(ball);
        System.out.print(Hint.BALL.message());
        System.out.print(" " + strike);
        System.out.println(Hint.STRIKE.message());
    }

    public static void askRestart() {
        System.out.println(END_MESSAGE);
        System.out.println(RESTART_MESSAGE);
        String action = Console.readLine();
        validateAction(action);
    }

    public static void validateAction(String action) {
        if (action.equals(RESTART)) {
            System.out.println(RESTART);
            Game.run();
        }
        if (action.equals(GAME_OVER)) {
            // 게임 종료
            System.out.println(GAME_OVER);
        }
        if (!action.equals(RESTART) && !action.equals(GAME_OVER)) {
            throw new IllegalArgumentException("Enter 1 to re-start, or 2 to quit.");
        }
    }
}