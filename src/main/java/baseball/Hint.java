package baseball;

import java.util.ArrayList;
import java.util.Collections;
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

    public static List<String> hintPerDigit(List<Integer> realAnswer, List<Integer> userAnswer) {
        List<String> digitHints = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Integer userDigit = userAnswer.get(i);
            String hint = compareDigit(realAnswer, userDigit, i);
            digitHints.add(hint);
        }
        return digitHints;
    }

    public static String finalHint(List<Integer> realAnswer, List<Integer> userAnswer) {
        List<String> hintList = hintPerDigit(realAnswer, userAnswer);
        int strikes = Collections.frequency(hintList, STRIKE);
        int balls = Collections.frequency(hintList, BALL);
        int nothings = Collections.frequency(hintList, NOTHING);

        if (nothings == 3)
            return NOTHING;
        if (strikes > 0 && balls == 0)
            return (strikes + STRIKE);
        if (strikes == 0 && balls > 0)
            return (balls + BALL);
        return (balls + BALL + " " + strikes + STRIKE);
    }
}
