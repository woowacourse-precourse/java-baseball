package baseball.computer;

import java.util.List;

public class ComputerGameEndCheckerImple implements ComputerGameEndChecker {
    @Override
    public boolean isNotGameEnd(List<Integer> inputNumbers, List<Integer> gameComputerNumbers) {
        if (inputNumbers.equals(gameComputerNumbers)) return false;
        return true;
    }
}