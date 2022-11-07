package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static List<Integer> compareWithComputer(String input, List<Integer> computer) {
        List<Integer> result = new ArrayList<>();
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i) - '0';
            if (cur == computer.get(i)) {
                strike++;
                continue;
            }

            if (computer.contains(cur)) {
                ball++;
            }
        }
        result.add(ball);
        result.add(strike);
        return result;
    }
}
