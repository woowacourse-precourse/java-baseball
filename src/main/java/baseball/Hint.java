package baseball;


import java.util.List;


public class Hint {
    private static String hint;
    private int includedNumber;
    private int matchingNumber;



    public String getHint() {
        hint ="";

        countMatchingNumbers(Game.correctAnswer, AnswerSheet.userAnswer);
        countIncludedNumbers(Game.correctAnswer, AnswerSheet.userAnswer);

        getHintOfBall();
        getHintOfStrike();
        getHintOfNothing();

        System.out.println(this.hint.trim());
        return this.hint.trim();
    }

    public void countMatchingNumbers(List<Integer> correctAnswer, List<Integer> userAnswer) {
        matchingNumber = 0;

        for (int index = 0; index < Game.answerLength; index++) {
            if (correctAnswer.get(index) == userAnswer.get(index)) {
                this.matchingNumber++;
            }
        }
    }

    public void countIncludedNumbers(List<Integer> correctAnswer, List<Integer> userAnswer) {
        includedNumber = 0;

        for (int index = 0; index < Game.answerLength; index++) {
            if (userAnswer.contains(correctAnswer.get(index))) {
                this.includedNumber++;
            }
        }
    }


    private void getHintOfBall() {
        if ((includedNumber - matchingNumber)!=0){
           this.hint = "" + (includedNumber - matchingNumber) + "볼";
        }
    }

    private void getHintOfStrike() {
        if (this.matchingNumber != 0) {
            this.hint += " " + matchingNumber + "스트라이크";
        }
    }

    private void getHintOfNothing() {
        if (this.hint.length() == 0) {
            this.hint = "낫싱";
        }
    }
}
