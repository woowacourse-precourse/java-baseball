package baseball.controller;

import java.util.*;

public class NumberController {
    private NumberController() {
    }

    public static List<Integer> calcStrikesAndBalls(List<Integer> users, List<Integer> answers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(answers.get(i))) {
                strikes++;
                continue;
            }
            if (users.contains(answers.get(i))) {
                balls++;
            }
        }
        return List.of(strikes, balls);
    }

}
