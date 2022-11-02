package baseball;

import java.util.List;

public class ResultCalculator {
    public static List<Integer> calculateBallAndStrike(List<Integer> computer, List<Integer> player) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int digit = 0; digit < computer.size(); digit++) {
            int computerNumber = computer.get(digit);
            int playerNumber = player.get(digit);

            if (computerNumber == playerNumber) {
                strikeCount++;
                continue;
            }

            if (computer.contains(playerNumber)) {
                ballCount++;
            }
        }

        return List.of(ballCount, strikeCount);
    }
}
