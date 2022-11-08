package baseball;

import java.util.List;

public class GameJudgement {
    final int NUMBER_LIMIT_LENGTH = 3;
    final int ZERO_COUNT = 0;
    final int THREE_STRIKE = 3;

    public boolean judge(List<Integer> randomNumbers, List<Integer> playerInputNumbers) {
        int strike = ZERO_COUNT;
        int ball = ZERO_COUNT;

        for (int i = 0; i < NUMBER_LIMIT_LENGTH; i++) {
            if (randomNumbers.get(i).equals(playerInputNumbers.get(i))) {
                strike++;
                continue;
            }

            if (playerInputNumbers.contains(randomNumbers.get(i))) {
                ball++;
            }
        }

        if (strike == THREE_STRIKE) {
            return true;
        }

        return false;
    }
}
