package baseball;

import java.util.ArrayList;
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

    public static List<String> compareAnswer(List<Integer> realAnswer, List<Integer> userAnswer) {
        List<String> digitHints = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Integer userDigit = userAnswer.get(i);
            String hint = compareDigit(realAnswer, userDigit, i);
            digitHints.add(hint);
        }
        return digitHints;
    }
}
