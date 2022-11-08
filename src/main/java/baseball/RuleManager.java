package baseball;

import java.util.List;

public class RuleManager {

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
}
