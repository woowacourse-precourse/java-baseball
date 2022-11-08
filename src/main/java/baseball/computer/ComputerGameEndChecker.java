package baseball.computer;

import java.util.List;

public interface ComputerGameEndChecker {
    boolean isNotGameEnd(List<Integer> input, List<Integer> now_numbers);
}
