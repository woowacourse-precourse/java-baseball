package baseball.domain.computer.generator;

import java.util.List;

public interface NumberGenerator {
    List<Integer> generateRandomNumbers(int startInclusive, int endInclusive, int count);
}
