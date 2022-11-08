package baseball;

import java.util.ArrayList;

public class Referee {

    private static RandomNumber randomNum;

    public static void generateRandom(int inputLength) {
        randomNum = RandomGenerator.generateRandom(new StringBuilder(), new ArrayList<Integer>(), inputLength);
    }

    public static String calculateAnswer(String userInput) {
        int ball;
        int strike;

        ball = calculateBall(userInput, randomNum);
        strike = calculateStrike(userInput, randomNum);
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        if (ball == 0 && strike != 0) {
            return (strike + "스트라이크");
        } else if (ball != 0 && strike == 0) {
            return (ball + "볼");
        }
        return (ball + "볼 " + strike + "스트라이크");
    }

    private static int calculateBall(String userInput, RandomNumber randNum) {
        int strikeNum = calculateStrike(userInput, randNum);
        int ballNum = 0;
        ballNum = randNum.countDuplicate(userInput);
        return (ballNum - strikeNum);
    }

    private static int calculateStrike(String userInput, RandomNumber randNum) {
        return randNum.countExactSame(userInput);
    }

    public static String testReferee(String input, RandomNumber randNum) {
        randomNum = randNum;
        return calculateAnswer(input);
    }
}
