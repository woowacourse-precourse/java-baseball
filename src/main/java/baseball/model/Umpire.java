package baseball.model;

import java.util.List;

public class Umpire {

    private int ballCount;
    private int strikeCount;

    public Umpire() {
        ballCount = 0;
        strikeCount = 0;
    }

    public boolean is3Strike() {
        return strikeCount == 3;
    }

    public void decideCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int idx = 0; idx < userNumbers.size(); idx++) {
            if (isStrike(computerNumbers, userNumbers.get(idx), idx)) {
                strikeCount++;
            } else if (isBall(computerNumbers, userNumbers.get(idx))) {
                ballCount++;
            }
        }
    }

    private boolean isStrike(List<Integer> computerNumbers, int userNumber, int idx) {
        if (computerNumbers.get(idx) == userNumber) {
            return true;
        }
        return false;
    }

    private boolean isBall(List<Integer> computerNumbers, int userNumber) {
        if (computerNumbers.contains(userNumber)) {
            return true;
        }
        return false;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}