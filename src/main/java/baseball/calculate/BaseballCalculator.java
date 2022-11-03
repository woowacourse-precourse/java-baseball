package baseball.calculate;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class BaseballCalculator {
    private int result = 0;

    public int strikeJudge(LinkedHashSet<Character> correctNum, LinkedHashSet<Character> inputNum) {

        result = 0;
        Iterator<Character> iterInputNum = inputNum.iterator();

        for (char character : correctNum) {
            if (character == iterInputNum.next()) {
                result += 1;
            }
        }

        return result;
    }

    public int ballJudge(LinkedHashSet<Character> correctNum, LinkedHashSet<Character> inputNum) {
        inputNum.retainAll(correctNum);
        return inputNum.size() - result;
    }
}
