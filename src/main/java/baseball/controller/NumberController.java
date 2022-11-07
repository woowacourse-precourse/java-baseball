package baseball.controller;

import baseball.vo.RandomNumber;
import java.util.*;

public class NumberController {
    private NumberController() {
    }

    public static List<Integer> getStrikesAndBalls(RandomNumber users, RandomNumber computers) {
        int strikes = 0;
        int balls = 0;
        List<Integer> userNumbers = users.getNumbers();
        List<Integer> answerNumbers = computers.getNumbers();

        for (int i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i).equals(answerNumbers.get(i))) {
                strikes++;
                continue;
            }
            if (answerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }
        return List.of(strikes, balls);
    }

}
