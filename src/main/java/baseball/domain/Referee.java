package baseball.domain;

import baseball.utils.UserInputValidator;

import java.util.List;

public class Referee {
    private final PlayResult playResult;

    public Referee(List<Integer> userBalls, List<Integer> computerBalls) {
        this.playResult = judgeGame(userBalls, computerBalls);
    }

    private PlayResult judgeGame(List<Integer> userBalls, List<Integer> computerBalls) {
        PlayResult playResult = new PlayResult();
        playResult.updateStrike(countStrike(userBalls, computerBalls));
        playResult.updateBall(countBall(userBalls, computerBalls));
        return playResult;
    }

    private int countStrike(List<Integer> userBalls, List<Integer> computerBalls) {
        int count = 0;
        for (int index = 0; index < UserInputValidator.INPUT_SIZE; index++) {
            count += isStrike(userBalls.get(index), computerBalls.get(index));
        }
        return count;
    }

    private int countBall(List<Integer> userBalls, List<Integer> computerBalls) {
        int count = 0;
        for (int index = 0; index < UserInputValidator.INPUT_SIZE; index++) {
            count += isBall(computerBalls, userBalls.get(index));
        }
        return count;
    }

    private static int isStrike(int userBall, int computerBall) {
        if (userBall == computerBall) {
            return 1;
        }
        return 0;
    }

    private int isBall(List<Integer> computerBall, int userBall) {
        if (computerBall.contains(userBall)) {
            return 1;
        }
        return 0;
    }

    public PlayResult notifyResult() {
        return playResult;
    }
}
