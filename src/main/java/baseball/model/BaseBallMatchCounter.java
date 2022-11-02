package baseball.model;

import java.util.List;

public class BaseBallMatchCounter {
    public int countStrike(String homeRun, String input) {
        int strike = 0;

        for (int i = 0; i < homeRun.length(); i++) {
            if (homeRun.charAt(i) == input.charAt(0)) {
                strike++;
            }
        }

        return strike;
    }

    public int countBall(String homeRun, String input) {
        int tempBall = 0;

        for (int i = 0; i < homeRun.length(); i++) {
            if (input.indexOf(homeRun.charAt(i)) >= 0 && input.charAt(i) != homeRun.charAt(i)) {
                tempBall++;
            }
        }
        return tempBall ;
    }

    public List<Integer> getBallGameResult(String homeRun, String input) {
      return List.of(countStrike(homeRun,input),countBall(homeRun, input));
    }
}
