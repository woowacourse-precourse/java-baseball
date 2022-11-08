package baseball;

import java.util.List;

import static baseball.Hint.NOTHING;
import static baseball.Hint.S3;

public class Referee {
    public Hint getHint(List<Integer> catcherBalls, List<Integer> pitcherBalls) {
        if (catcherBalls.equals(pitcherBalls)) {
            return S3;
        }
        List<Integer> ballAndStrikeCounts = countBallAndStrike(catcherBalls, pitcherBalls);
        return generateHint(ballAndStrikeCounts);
    }

    private List<Integer> countBallAndStrike(List<Integer> catcherBalls, List<Integer> pitcherBalls) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int pitcherBallIdx = 0; pitcherBallIdx < pitcherBalls.size(); pitcherBallIdx++) {
            int pitcherBall = pitcherBalls.get(pitcherBallIdx);
            if (catcherBalls.contains(pitcherBall) && !compare(catcherBalls.indexOf(pitcherBall), pitcherBallIdx)) {
                ballCount++;
            } else if (catcherBalls.contains(pitcherBall) && compare(catcherBalls.indexOf(pitcherBall), pitcherBallIdx)) {
                strikeCount++;
            }
        }
        return List.of(ballCount, strikeCount);
    }

    private boolean compare(int catcherBallIdx, int pitcherBallIdx) {
        return catcherBallIdx == pitcherBallIdx;
    }

    private Hint generateHint(List<Integer> ballAndStrikeCounts) {
        int ballCount = ballAndStrikeCounts.get(0);
        int strikeCount = ballAndStrikeCounts.get(1);
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }
        StringBuilder hintBuffer = new StringBuilder();
        if (ballCount != 0) {
            hintBuffer.append("B").append(ballCount);
        }
        if (strikeCount != 0) {
            hintBuffer.append("S").append(strikeCount);
        }
        return Hint.valueOf(hintBuffer.toString());
    }
}