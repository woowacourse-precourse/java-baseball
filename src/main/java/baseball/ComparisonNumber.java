package baseball;

import java.util.List;

public class ComparisonNumber {
    private int ball;
    private int strike;

    public void checkResult(List<Integer> computerNumber, List<Integer> userNember) {
        ball = 0;
        strike = 0;

        for (int i = 0; i < computerNumber.size(); i++) {
            for (int j = 0; j < userNember.size(); j++) {
                if (computerNumber.get(i) == userNember.get(j)) {
                    if (i == j) {
                        strike++;
                    }else{
                        ball++;
                    }
                }
            }
        }


    }
    public int getStrike() {
        return this.strike;
    }
    public String Message() {
        String result = "";

        if (ball == 0 && strike == 0) {
            result += "낫싱";
        } else if (ball > 0 && strike > 0) {
            result += ball + "볼" + " " + strike + "스트라이크";
        } else if (ball > 0) {
            result += ball + "볼";
        } else if (strike > 0) {
            result += strike + "스트라이크";
        }

        return result;
    }

}
