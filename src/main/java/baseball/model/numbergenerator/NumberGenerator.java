package baseball.model.numbergenerator;

import baseball.model.numbers.Numbers;

public interface NumberGenerator {
    Numbers generateRandomNumber(int count);
}