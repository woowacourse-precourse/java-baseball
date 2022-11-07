package baseball;

import java.util.List;

public class GetBallAndStrikeCount {
    public int strikeCount(List<String> randomNumber, List<String> userNumber) {
        int strikeCount = 0;

        for (int strikeLoop = 0; strikeLoop < 3; strikeLoop++) {
            if (randomNumber.get(strikeLoop).equals(userNumber.get(strikeLoop))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int ballCount(List<String> randomNumber, List<String> userNumber) {
        int ballCount = 0;
        for (int ballLoop = 0; ballLoop < 3; ballLoop++) {
            if (!(randomNumber.get(ballLoop).equals(userNumber.get(ballLoop))) &&
                    randomNumber.contains(userNumber.get(ballLoop))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
