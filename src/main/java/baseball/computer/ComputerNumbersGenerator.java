package baseball.computer;

import java.util.List;

public interface ComputerNumbersGenerator {
    List<Integer> autoCreateNumbers();
    List<Integer> createNumbers(List<Integer> numbers);
}
