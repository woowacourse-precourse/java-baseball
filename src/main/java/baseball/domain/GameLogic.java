package baseball.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class GameLogic {
    private final int INPUT_DIGIT;
    private final String result;

    public GameLogic(RandomNumbers computerNumbers, List<Integer> playerNumbers) {
        this.INPUT_DIGIT = 3;
        this.result = baseBallGame(computerNumbers, playerNumbers);
    }

    private String baseBallGame(RandomNumbers computerNumbers, List<Integer> playerNumbers) {
        int strikeScore = getStrikeCount(computerNumbers, playerNumbers);
        int ballScore = getBallCount(computerNumbers, playerNumbers);

        StringJoiner sj = new StringJoiner(" ");
        if (ballScore != 0) {
            sj.add(String.format("%d볼", ballScore));
        }
        if (strikeScore != 0) {
            sj.add(String.format("%d스트라이크", strikeScore));
        }
        if (ballScore == 0 && strikeScore == 0) {
            sj.add("낫싱");
        }
        return sj.toString();
    }

    private int getStrikeCount(RandomNumbers computerNumbers, List<Integer> playerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < INPUT_DIGIT; i++) {
            if (Objects.equals(computerNumbers.get(i), playerNumbers.get(i))) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    private int getBallCount(RandomNumbers computerNumbers, List<Integer> playerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < INPUT_DIGIT; i++) {
            int playNumber = playerNumbers.get(i);
            int computerNumberIndex = computerNumbers.indexOf(playNumber);
            if (computerNumberIndex != -1 && computerNumberIndex != i) {
                ballCount += 1;
            }
        }
        return ballCount;
    }

    public boolean equals(String value) {
        return result.equals(value);
    }

    @Override
    public String toString() {
        return result;
    }
}
