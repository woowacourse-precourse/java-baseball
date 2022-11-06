package baseball.Utils;

import java.util.List;

public class NumberListComparator {

    private final int MAX_INPUTTABLE_NUMBER_LENGTH = 3;

    private MessagePrinter print;
    private List<Integer> answerNumbers;

    public NumberListComparator() {
        this.print = new MessagePrinter();
    }

    public void setAnswerNumberListForComparing(List<Integer> answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public void compareUserNumbersAndAnswer(List<Integer> userNumbers) {

        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < MAX_INPUTTABLE_NUMBER_LENGTH; i++) {
            if (userNumbers.get(i) == answerNumbers.get(i)) {
                strikeCount++;
            } else if (answerNumbers.contains(userNumbers.get(i))) {
                ballCount++;
            }
        }

        print.countBallAndStrike(ballCount, strikeCount);
    }

    public boolean isAnswerNumbers(List<Integer> userNumbers) {
        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i) != answerNumbers.get(i)) {
                return false;
            }
        }

        return true;
    }
}
