package baseball;

import java.util.List;

import static baseball.Constant.*;

public class Hint {
    public static String compareDigit(List<Integer> realAnswer, Integer userDigit, int idx) {
        Integer realDigit = realAnswer.get(idx);

        if (realDigit.equals(userDigit))
            return STRIKE;
        if (realAnswer.contains(userDigit))
            return BALL;
        return NOTHING;
    }
}
