package baseball;

import java.util.List;

import static baseball.Constant.*;

public class Game {
    static int strike;
    static int ball;

    public static void playGame() {
        System.out.println(START_MESSAGE);
        List<Integer> computerAnswer = Computer.generateNumber();
        do {
            countStrikeBall(computerAnswer, Computer.getPlayerAnswer());
        } while (!getResult());
    }

    public static void countStrikeBall(List<Integer> computerAnswer, String playerAnswerStr) {
        List<Integer> playerAnswer = Computer.stringToIntegerList(playerAnswerStr);
        strike = 0;
        ball = 0;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            if (computerAnswer.get(i).equals(playerAnswer.get(i))) {
                strike++;
            } else if (computerAnswer.contains(playerAnswer.get(i))) {
                ball++;
            }
        }
    }

    private static boolean getResult() {
        if (strike == NUMBER_SIZE) {
            System.out.println(NUMBER_SIZE + STRIKE_MESSAGE);
            System.out.println(SUCCESS_MESSAGE);
            return true;
        } else if (strike == 0 && ball == 0) {
            System.out.println(NOTHING_MESSAGE);
            return false;
        } else {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            return false;
        }
    }
}
