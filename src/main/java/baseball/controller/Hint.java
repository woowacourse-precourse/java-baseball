package baseball.controller;

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
}


