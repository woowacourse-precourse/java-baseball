package baseball.domain;

import java.util.List;
import java.util.Objects;

public class GameDomain {
    public static int countBall(List<Integer> player, List<Integer> computer) { //Game Class
        int count = 0;
        boolean isContains;
        boolean isMatches;
        for (int i = 0; i < player.size(); i++) {
            isContains = computer.contains(player.get(i));
            isMatches = Objects.equals(player.get(i), computer.get(i));
            if (isContains && !isMatches) count += 1;
        }
        return count;
    }

    public static int countStrike(List<Integer> player, List<Integer> computer) { //Game Class
        int count = 0;
        boolean isMatches;
        for (int i = 0; i < player.size(); i++) {
            isMatches = Objects.equals(player.get(i), computer.get(i));
            if (isMatches) count += 1;
        }
        return count;
    }
}
