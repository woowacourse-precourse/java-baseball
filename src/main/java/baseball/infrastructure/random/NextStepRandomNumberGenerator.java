package baseball.infrastructure.random;

import baseball.application.random.RandomNumberGenerator;
import baseball.application.random.Range;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NextStepRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public List<Integer> generateUniqueNumberInRange(Range range, int count) {
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < count) {
            // Application Test 통과를 위해 pickNumberInRange 사용
            int number = Randoms.pickNumberInRange(range.startInclusive(), range.endInclusive());
            numbers.add(number);
        }

        return new ArrayList<>(numbers);
    }
}
