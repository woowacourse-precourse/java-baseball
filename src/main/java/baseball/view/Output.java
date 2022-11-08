package baseball.view;

import baseball.model.CompareInputNumber;

import java.util.List;

public class Output {
    CompareInputNumber compareInput = new CompareInputNumber();

    public String outputString(List<Integer> random_num, List<Integer> user_num) {
        List<Integer> ball_and_strike = compareInput.compareRandomandUser(random_num, user_num);

        if(ball_and_strike.get(0).equals(0)) {
            if(ball_and_strike.get(1).equals(0)) return "낫싱";
            return ball_and_strike.get(1) + "스트라이크";
        }
        if (ball_and_strike.get(1).equals(0)) return ball_and_strike.get(0) + "볼";
        return ball_and_strike.get(0) + "볼 " + ball_and_strike.get(1) + "스트라이크";
    }

}
