package baseball.service;



public class NumberCondition {
    private final String answer;

    public NumberCondition(String answer) {
        this.answer = answer;
    }

    boolean doesContain(String oneOfNum) {
        return answer.contains(oneOfNum);
    }

    protected boolean isDigitCorrect(String oneOfNum, int digit) {
        boolean result = false;
        if (answer.indexOf(oneOfNum) == digit) {
            result = true;
        }
        return result;
    }
}
