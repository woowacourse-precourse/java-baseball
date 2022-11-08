package baseball;

public class BaseballRefree {

    private String answerNumber;
    private boolean[] answerNumberFlags = new boolean[10];

    private void setAnswerNumberFlags() {
        for (char ch : this.answerNumber.toCharArray()) {
            this.answerNumberFlags[Character.getNumericValue(ch)] = true;
        }
    }

    public void setAnswerNumber(String answerNumber) {
        this.answerNumber = answerNumber;
        this.setAnswerNumberFlags();
    }

}
