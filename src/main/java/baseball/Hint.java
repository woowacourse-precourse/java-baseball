package baseball;

import java.util.List;

public class Hint {
    private final String letterBall = "볼";
    private final String letterStrike = "스트라이크";
    private final String letterNothing = "낫싱";

    private String hint ="";

    private int includedNumber;
    private int matchingNumber;

    public Hint(List<Integer> correctAnswer, List<Integer> userAnswer) {
        countMatchingNumbers(correctAnswer, userAnswer);
        countIncludedNumbers(correctAnswer, userAnswer);
        getHintOfBall();
        getHintOfStrike();
        this.hint = this.getHint().trim();
    }

    public String getHint() {
        return this.hint;
    }

    private void countMatchingNumbers(List<Integer> correctAnswer, List<Integer> userAnswer) {
        for (int index = 0; index < Start.answerLength; index++) {
            if (correctAnswer.get(index) == userAnswer.get(index)) {
                this.matchingNumber++;
            }
        }
    }

    private void countIncludedNumbers(List<Integer> correctAnswer, List<Integer> userAnswer) {
        for (int index = 0; index < Start.answerLength; index++) {
            if (userAnswer.contains(correctAnswer.get(index))) {
                this.includedNumber++;
            }
        }
    }

    private void getHintOfBall() {
        if (this.includedNumber == 0) {
            this.hint = letterNothing;
        } else {
            this.hint += "" + (includedNumber - matchingNumber) + letterBall;
        }
    }

    private void getHintOfStrike() {
        if (this.includedNumber == 0) {
            this.hint = letterNothing;
        } else {
            this.hint += " " + matchingNumber + letterStrike;
        }
    }
}
