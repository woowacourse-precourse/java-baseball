package baseball;

import java.util.Arrays;
import java.util.List;

public class GameScore {
    public static List<Integer> getGameScore(List<Integer> numbers, List<Integer> computers) {
        int strike = 0;
        int ball = 0;

        for (int digit = 0; digit < numbers.size(); digit++) {
            if (numbers.get(digit).equals(computers.get(digit))) {
                strike++;
            } else if (computers.contains(numbers.get(digit))) {
                ball++;
            }
        }

        return Arrays.asList(ball, strike);
    }
}
