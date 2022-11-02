package baseball.application.random;

import java.util.List;

public interface RandomNumberGenerator {

    List<Integer> generateUniqueNumberInRange(Range range, int count);
}
