package baseball;

import baseball.model.Numbers;

public interface NumberGenerator {
    Numbers generateUniqueNumbersInRange(int startNumber, int endNumber, int count);
}
