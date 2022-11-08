package baseball.controller;

import baseball.view.OutputView;

import java.util.List;

import static baseball.model.Constant.NUM_SIZE;

public class Hint {
    public int strike = 0;
    public int ball = 0;

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
    }

    public void ResultHint() {
        NothingHint();
        BallHint();
        StrikeHint();
        BallStrikeHint();
    }

    private void NothingHint() {
        if (strike == 0 && ball == 0) {
            OutputView.NothingOutput();
        }
    }

    private void BallHint() {
        if (strike == 0 && ball != 0) {
            OutputView.BallOutput(ball);
        }
    }

    private void StrikeHint() {
        if (strike != 0 && ball == 0) {
            OutputView.StrikeOutput(strike);
        }
    }

    private void BallStrikeHint() {
        if (strike != 0 && ball != 0) {
            OutputView.BallStrikeOutput(ball, strike);
        }
    }
}


