package baseball.domain.game;

import java.util.List;

public class Count {

    int numberSize = 3;

    public Count() {
    }

    public int countBall(List<String> computerAnswer, List<String> userAnswer) {
        int ballCount = 0;
        for (int i = 0; i < numberSize; i++) {
            if (computerAnswer.contains(userAnswer.get(i)) && computerAnswer.indexOf(userAnswer.get(i)) != i) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int countStrike(List<String> computerAnswer, List<String> userAnswer) {
        int strikeCount = 0;
        for (int i = 0; i < numberSize; i++) {
            if (computerAnswer.get(i).equals(userAnswer.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
