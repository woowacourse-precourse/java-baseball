package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Judge {
    private final List<Integer> ANSWER;

    public Judge(List<Integer> ANSWER) {
        this.ANSWER = ANSWER;
    }

    private int countBall(List<Integer> guess) {
        return (int) guess.stream()
                .filter(number -> ANSWER.contains(number))
                .count();
    }
}
