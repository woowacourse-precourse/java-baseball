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
}
