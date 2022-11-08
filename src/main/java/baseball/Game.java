package baseball;

import java.util.List;

public class Game {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

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
        EndGame.askRestart();
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
            printNothing();
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

    public static void printNothing(){
        System.out.println(Hint.NOTHING.message());
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
}