package baseball.data;

import java.util.ArrayList;
import java.util.List;

public class AnswerNumber extends BaseballNumber {

    private static AnswerNumber answerNumber;
    private List<Integer> numbers;

    private AnswerNumber() {
        numbers = new ArrayList<>();
    }

    public static AnswerNumber getInstance() {
        if(answerNumber == null) {
            answerNumber = new AnswerNumber();
        }

        return answerNumber;
    }
}
