package baseball.domain.count;

import baseball.domain.ThreeDigitNum;

abstract public class Count {

    protected ThreeDigitNum answer;
    protected ThreeDigitNum input;
    protected int count;

    public Count(ThreeDigitNum answer, ThreeDigitNum input) {
        this.answer = answer;
        this.input = input;

        this.count = 0;

        update();
    }

    @Override
    abstract public String toString();

    public boolean isZero() {
        return count == 0;
    }

    abstract void update();

    boolean isEqualBirth(int idx) {
        return isEqualValue(answer.list().get(idx), input.list().get(idx));
    }

    boolean isEqualValue(Integer answerDigit, Integer inputDigit) {
        return answerDigit.equals(inputDigit);
    }

    protected void add() {
        ++count;
    }

}
