package baseball;

import java.util.List;

public class HintCalculator {

    private static boolean isBall(int number, List<Integer> playerNumber) {
        return playerNumber.contains(number);
    }

    private static boolean isStrike(int randomNumberIndex, int playerNumberIndex) {
        return randomNumberIndex == playerNumberIndex;
    }

    public static boolean isNothing(int ball, int strike) {
        return ball == 0 && strike == 0;
    }

    public static boolean isThreeStrike(int strike) {
        return strike == Game.NUMBER_SIZE;
    }

    public static boolean calculateHint(List<Integer> randomNumber, List<Integer> playerNumber) {
        int ball = 0, strike = 0;
        for (Integer number: randomNumber) {
            if (isBall(number, playerNumber)) {
                int randomNumberIndex = randomNumber.indexOf(number);
                int playerNumberIndex = playerNumber.indexOf(number);
                if (isStrike(randomNumberIndex, playerNumberIndex)) {
                    strike ++;
                }
                else {
                    ball ++;
                }
            }
        }
        return HintOutput.printHint(ball, strike);
    }
}
