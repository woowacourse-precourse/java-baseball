package baseball.service;

import baseball.domain.Baseball;
import java.util.List;

public class BaseballServiceImpl implements BaseballService {

    @Override
    public Baseball judge(final List<Integer> numbers, final List<Integer> goal) {
        if (numbers.size() != goal.size()) {
            throw new IllegalArgumentException();
        }
        final int strikeCount = countStrike(numbers, goal);
        final int ballCount = countBall(numbers, goal, strikeCount);
        return new Baseball(strikeCount, ballCount);
    }

    private int countStrike(final List<Integer> numbers, final List<Integer> goal) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(goal.get(i))) {
                count++;
            }
        }
        return count;
    }

    private int countBall(final List<Integer> numbers, final List<Integer> goal,
        final int strikeCount) {
        int count = 0;
        for (Integer number : numbers) {
            if (goal.contains(number)) {
                count++;
            }
        }
        return count - strikeCount;
    }
}
