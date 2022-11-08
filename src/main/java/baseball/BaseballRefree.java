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


    private int getBallCount(String numbers){
        int count = 0;

        for (char ch : numbers.toCharArray()) {
            if (answerNumberFlags[Character.getNumericValue(ch)]) count += 1;
        }

        return count;
    }
}
