package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.GameMessage.*;
import static baseball.InputNumberExceptionChecker.hasException;

public class Application {
    public static void main(String[] args) {

        NumberMaker numberMaker = new NumberMaker();
        game(numberMaker);
    }

    private static void game(NumberMaker numberMaker) {
        int restartSign;
        int ball;
        int strike;
        String randomNumber;
        String playerNumber;
        boolean isContinuousGame = true;
        randomNumber = numberMaker.makeRandomNumber();
        System.out.println(GAME_START_MESSAGE);

        while (isContinuousGame) {
            System.out.printf(INPUT_NUMBER_MESSAGE);
            playerNumber = numberMaker.makePlayerNumber();
            hasException(playerNumber);
            BallStrikeChecker ballStrikeChecker = new BallStrikeChecker();
            ball = ballStrikeChecker.countBall(randomNumber, playerNumber);
            strike = ballStrikeChecker.countStrike(randomNumber, playerNumber);
            ballStrikeChecker.printHint(ball, strike);

            // 완전히 동일한 경우
            if (randomNumber.equals(playerNumber)) {
                System.out.println(THREE_STRIKE_MESSAGE);
                System.out.println(RESTART_OR_NOT_MESSAGE);
                restartSign = Integer.parseInt(Console.readLine());
                hasException(restartSign);
                isContinuousGame = restart(restartSign);

            }
        }
    }

    private static boolean restart(int restartSign) {
        if (restartSign == 1) {
            return true;
        } else {
            return false;
        }
    }


}
