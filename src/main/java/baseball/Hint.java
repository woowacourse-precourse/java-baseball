package baseball;


import java.util.List;

public class Hint {
    private String hint ="";

    private int includedNumber;
    private int matchingNumber;

    public Hint() {
        AnswerSheet answerSheet = new AnswerSheet();
        countMatchingNumbers(Game.correctAnswer, answerSheet.userAnswer);
        countIncludedNumbers(Game.correctAnswer, answerSheet.userAnswer);
        getHintOfBall();
        getHintOfStrike();
        this.hint = this.getHint().trim();
    }

    public String getHint() {
        return this.hint;
    }

    private void countMatchingNumbers(List<Integer> correctAnswer, List<Integer> userAnswer) {
        for (int index = 0; index < Game.answerLength; index++) {
            if (correctAnswer.get(index) == userAnswer.get(index)) {
                this.matchingNumber++;
            }
        }
    }

    private void countIncludedNumbers(List<Integer> correctAnswer, List<Integer> userAnswer) {
        for (int index = 0; index < Game.answerLength; index++) {
            if (userAnswer.contains(correctAnswer.get(index))) {
                this.includedNumber++;
            }
        }
    }

    private void getHintOfBall() {
        if (this.includedNumber == 0) {
            this.hint = "낫싱";
        } else {
            this.hint += "" + (includedNumber - matchingNumber) + "볼";
        }
    }

    private void getHintOfStrike() {
        if (this.includedNumber == 0) {
            this.hint = "낫싱";
        } else {
            this.hint += " " + matchingNumber + "스트라이크";
        }
    }
}
