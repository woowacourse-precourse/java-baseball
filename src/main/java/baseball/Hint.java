package baseball;


import java.util.List;


public class Hint {
    protected static String hint;
    protected int includedNumber;
    protected int matchingNumber;


    public String get() {
        hint = "";

        countMatchingNumbers(Game.correctAnswer, Pitch.userAnswer);
        countIncludedNumbers(Game.correctAnswer, Pitch.userAnswer);

        getHintOfBall();
        getHintOfStrike();
        getHintOfNothing();

        return this.hint.trim();
    }

    public void show() {
        System.out.println(this.hint.trim());
    }

    protected void countMatchingNumbers(List<Integer> correctAnswer, List<Integer> userAnswer) {
        matchingNumber = 0;

        for (int index = 0; index < Game.answerLength; index++) {
            if (correctAnswer.get(index) == userAnswer.get(index)) {
                this.matchingNumber++;
            }
        }
    }

    protected void countIncludedNumbers(List<Integer> correctAnswer, List<Integer> userAnswer) {
        includedNumber = 0;

        for (int index = 0; index < Game.answerLength; index++) {
            if (userAnswer.contains(correctAnswer.get(index))) {
                this.includedNumber++;
            }
        }
    }


    protected void getHintOfBall() {
        if ((includedNumber - matchingNumber) != 0) {
            this.hint = "" + (includedNumber - matchingNumber) + "볼";
        }
    }

    protected void getHintOfStrike() {
        if (this.matchingNumber != 0) {
            this.hint += " " + matchingNumber + "스트라이크";
        }
    }

    protected void getHintOfNothing() {
        if (this.hint.isEmpty()) {
            this.hint = "낫싱";
        }
    }
}
