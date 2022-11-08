package baseball;

import java.util.List;

public class RuleManager {

    public static final int ZERO_STRIKE_NUMBER = 0;
    public static final int TWO_STRIKE_NUMBER = 2;
    public static final int THREE_STRIKE_NUMBER = 3;
    public static final int ZERO_BALL_NUMBER = 0;
    public static final int THREE_BALL_NUMBER = 3;

    public static int countStrike(User user, List<Long> computerNumbers) {
        int strikeCount = 0;
        int userNumberIndex = 0;
        for (Long comNumber : computerNumbers) {
            if (comNumber.equals(user.getUserNumbers().get(userNumberIndex++))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public static int countBall(User user, List<Long> computerNumbers) {
        int ballCount = 0;
        for (Long userNumber : user.getUserNumbers()) {
            if (computerNumbers.contains(userNumber)) {
                ballCount++;
            }
        }
        return ballCount - countStrike(user, computerNumbers);
    }

    public static void compareStrikeBall(User user, List<Long> computerNumbers) {
        if (countStrike(user, computerNumbers) > ZERO_STRIKE_NUMBER && countBall(user, computerNumbers) > ZERO_BALL_NUMBER) {
            if (countStrike(user, computerNumbers) < TWO_STRIKE_NUMBER && countBall(user, computerNumbers) < THREE_BALL_NUMBER) {
                Output.printStrikeBall(countStrike(user, computerNumbers), countBall(user, computerNumbers));
            }
        }
    }
}
