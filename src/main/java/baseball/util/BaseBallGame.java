package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    private final List<Integer> computerRandomThreeValue;

    public BaseBallGame(List<Integer> computerRandomThreeValue) {
        this.computerRandomThreeValue = List.copyOf(computerRandomThreeValue);
    }


    public void gameStart () {
        String userData;
        do {

            userData = Console.readLine();
            List<Integer> ballStrikeCount = computerRandomCompareToUserInput(computerRandomThreeValue, userData);

        } while (false);
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
}
