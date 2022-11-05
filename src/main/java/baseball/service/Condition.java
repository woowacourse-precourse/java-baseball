package baseball.service;


public class Condition {
    private final String answer;

    Condition(String answer) {
        this.answer = answer;
    }

    boolean doesContain(String oneOfNum) {
        return answer.contains(oneOfNum);
    }

    boolean isDigitCorrect(String oneOfNum, int digit) {
        boolean result = false;
        if (answer.indexOf(oneOfNum) == digit) {
            result = true;
        }
        return result;
    }
}
