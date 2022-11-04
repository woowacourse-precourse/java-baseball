package baseball.controller;

import java.util.*;

public class NumberController {
    private NumberController() {
    }

    public static List<Integer> getStrikesAndBalls(List<Integer> users, List<Integer> computers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(computers.get(i))) {
                strikes++;
                continue;
            }
            if (computers.contains(users.get(i))) {
                balls++;
            }
        }
        return List.of(strikes, balls);
    }

}
