package baseball.controller;

import java.util.List;

import static baseball.model.Constant.NUM_SIZE;

public class Hint {
    public int strike = 0;
    public int ball = 0;
    public String hintResult = "";

    public Hint(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i<NUM_SIZE; i++) {
            if (computer.get(i) == user.get(i)) {
                strike += 1;
                continue;
            }
            if (computer.contains(user.get(i))) {
                ball += 1;
            }
        }
        hintResult = HintResult(strike,ball);
    }

    private static String HintResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return ("낫싱");
        }
        if (strike == 3) {
            return ("3스트라이크");
        }
        if (strike == 0) {
            return (ball+"볼");
        }
        if (ball == 0) {
            return (strike+"스트라이크");
        }
        return (ball+"볼 "+strike+"스트라이크");
    }
}


