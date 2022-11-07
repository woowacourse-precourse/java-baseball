package baseball.entity;


public class Condition {
    private final String answer;

    public Condition(String answer) {
        this.answer = answer;
    }

    public boolean doesContain(String oneOfNum) {
        return answer.contains(oneOfNum);
    }

    public boolean isDigitCorrect(String oneOfNum, int digit) {
        return answer.indexOf(oneOfNum) == digit;
    }
}
