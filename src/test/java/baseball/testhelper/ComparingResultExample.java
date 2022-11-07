package baseball.testhelper;

import java.util.ArrayList;
import java.util.List;

public enum ComparingResultExample {
    RANDOM_NUMBER(4, 5, 6, "랜덤 숫자"),
    ONE_BALL(1, 2, 4, "1볼"),
    TWO_BALL(1, 4, 5, "2볼"),
    THREE_BALL(5, 6, 4, "3볼"),
    ONE_STRIKE(1, 2, 6, "1스트라이크"),
    TWO_STRIKE(1, 5, 6, "2스트라이크"),
    THREE_STRIKE(4, 5, 6, "3스트라이크"),
    ONE_BALL_ONE_STRIKE(1, 5, 4, "1볼 1스트라이크"),
    TWO_BALL_ONE_STRIKE(6, 5, 4, "2볼 1스트라이크"),
    NOTHING(1, 2, 3, "낫싱");

    private final List<Integer> numbers = new ArrayList<>();
    private final String resultSentence;

    ComparingResultExample(int n1, int n2, int n3, String sentence) {
        this.numbers.addAll(List.of(n1, n2, n3));
        this.resultSentence = sentence;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public String getResultSentence() {
        return this.resultSentence;
    }
}
