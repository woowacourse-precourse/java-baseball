package baseball.hint;

import java.util.List;
import java.util.Objects;

public class HintCalculatorImp implements HintCalculator {

    @Override
    public Hint getHint(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;
        for (Integer key : computer) {
            if (Objects.equals(user.indexOf(key), computer.indexOf(key))) {
                strike++;
                continue;
            }
            if (user.contains(key)) {
                ball++;
            }
        }

        return Hint.builder().strike(strike).ball(ball).build();
    }
}
