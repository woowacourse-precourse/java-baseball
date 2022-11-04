package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    private final List<Integer> computerRandomThreeValue;

    private static final int BALL = 0;
    private static final int STRIKE = 1;

    public BaseBallGame(List<Integer> computerRandomThreeValue) {
        this.computerRandomThreeValue = List.copyOf(computerRandomThreeValue);
    }


    public void gameStart () {
        String userData;
        List<Integer> ballStrikeCount;
        do {

            userData = Console.readLine();
            ballStrikeCount = computerRandomCompareToUserInput(computerRandomThreeValue, userData);
            printByBallAndStrikeCount(ballStrikeCount);

        } while (ballStrikeCount.get(STRIKE) != 3);
    }


    private static List<Integer> computerRandomCompareToUserInput (List<Integer> computerRandom, String userInput) {
        int ballCount = 0,
                strikeCount = 0;

        for (int i = 0; i < computerRandom.size(); i++) {
            if (userInput.charAt(i) - '0' == computerRandom.get(i)) {
                strikeCount++;
                continue;
            }

            if (computerRandom.contains(userInput.charAt(i) - '0')) {
                ballCount++;
            }
        }

        return List.of(ballCount, strikeCount);
    }


    private static void printByBallAndStrikeCount (List<Integer> ballStrikeCount) {
        if (ballStrikeCount.get(BALL) == 0 && ballStrikeCount.get(STRIKE) == 0) {
            // printCode
            return;
        }

        if (ballStrikeCount.get(STRIKE) == 3) {
            // printCode
            return;
        }

        // printCode
    }
}
