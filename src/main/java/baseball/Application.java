package baseball;

import camp.nextstep.edu.missionutils.Console;

import static resource.GameMessage.*;
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
        randomNumber = numberMaker.makeInitRandomNumber();
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
                isContinuousGame = isEqual(randomNumber, playerNumber);
                randomNumber = makeNewRandomNumber(isContinuousGame);
            }
        }
    }

    public static String makeNewRandomNumber(boolean isContinuousGame) {
        NumberMaker numberMaker = new NumberMaker();
        String newString;
        if (isContinuousGame) {
            newString = numberMaker.makeInitRandomNumber();
            return newString;
        } else {
            return null;
        }
    }

    public static boolean isEqual(String randomNumber, String playerNumber) {
        int restartSign;
        boolean isContinuousGame;
        System.out.println(THREE_STRIKE_MESSAGE);
        System.out.println(RESTART_OR_NOT_MESSAGE);
        restartSign = Integer.parseInt(Console.readLine());
        hasException(restartSign);
        if (restartSign == 1) {
            isContinuousGame = true;
        } else {
            isContinuousGame = false;
        }
        return isContinuousGame;
    }






}
