package baseball;

import java.util.ArrayList;

public class Referee {

    private static final int CORRECTINPUTLENGTH = 3;
    private static RandomNumber randNum;

    Referee() {
        randNum = RandomGenerator.generateRandom(new StringBuilder(), new ArrayList<Integer>());
    }

    public static String calculateAnswer(String userInput) {
        int ball;
        int strike;

        ball = calculateBall(userInput, randNum);
        strike = calculateStrike(userInput, randNum);
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (ball != 0 && strike != 0) {
            return (ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0 && strike == 0) {
            return (ball + "볼");
        } else if (ball == 0 && strike != 0) {
            return (strike + "스트라이크");
        }
        return "";
    }

    private static int calculateBall(String userInput, RandomNumber randNum) {
        int strikeNum = calculateStrike(userInput, randNum);
        int ballNum = 0;
        ballNum = randNum.countDuplicate(userInput);
        return (ballNum - strikeNum);
    }

    private static int calculateStrike(String userInput, RandomNumber randNum) {
        int strikeCnt = 0;
        for (int i = 0; i < CORRECTINPUTLENGTH; i++) {
            if (userInput.charAt(i) == randNum.randomNumInChar(i)) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

}
