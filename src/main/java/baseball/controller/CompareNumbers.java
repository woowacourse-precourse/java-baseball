package baseball.controller;

import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.Objects;

public class CompareNumbers {

    public int compareNumbers(ArrayList<Integer> userNumberList, ArrayList<Integer> computerNumberList) {

        int strike = countStrike(userNumberList, computerNumberList);
        int ball = countBall(userNumberList, computerNumberList);

        OutputView.printHint(ball, strike);

        return strike;
    }

    public int countStrike(ArrayList<Integer> userNumberList, ArrayList<Integer> computerNumberList) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumberList.get(i) == computerNumberList.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(ArrayList<Integer> userNumberList, ArrayList<Integer> computerNumberList) {
        int ballCount = 0;
        for (int i = 0; i < userNumberList.size(); i++) {
            if (!Objects.equals(computerNumberList.get(i), userNumberList.get(i)) && computerNumberList.contains(userNumberList.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }
}
