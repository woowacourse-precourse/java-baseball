package baseball.Utils;

import java.util.List;

public class Comparator {

    private Printer print;

    public Comparator() {
        this.print = new Printer();
    }

    public boolean compare(List<Integer> userNumbers, List<Integer> answerNumbers) {

        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i) == answerNumbers.get(i)) {
                strikeCount++;
            } else if (answerNumbers.contains(userNumbers.get(i))) {
                ballCount++;
            }
        }

        print.countBall(ballCount, strikeCount);

        return isAnswer(userNumbers, answerNumbers);
    }

    private boolean isAnswer(List<Integer> userNumbers, List<Integer> answerNumbers) {
        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i) != answerNumbers.get(i)) {
                return false;
            }
        }

        return true;
    }
}
