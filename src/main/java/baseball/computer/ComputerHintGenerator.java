package baseball.computer;

import java.util.List;

public interface ComputerHintGenerator {
    String generateHintForInput(List<Integer> inputNumbers, List<Integer> gameComputerNumbers);
}
