package baseball.service;


import baseball.mapper.StringMapper;

public class NumberCondition {
    private final String answer;

    public NumberCondition(String answer) {
        this.answer = answer;
    }

    private boolean doesContain(String oneOfNum) {
        return answer.contains(oneOfNum);
    }

    private boolean isDigitCorrect(String oneOfNum, int digit) {
        boolean result = false;
        if (answer.indexOf(oneOfNum) == digit) {
            result = true;
        }
        return result;
    }
}
