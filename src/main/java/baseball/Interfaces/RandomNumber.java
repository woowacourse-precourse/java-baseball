package baseball.Interfaces;

import java.util.List;

public interface RandomNumber {
    int MAX_NUMBER_OF_RANGE = 9;
    int MIN_NUMBER_OF_RANGE = 1;
    int MAX_NUMBER_OF_DIGIT = 3;

    List<Integer> getNumbers();
}
