package baseball.infrastructure.random;

import baseball.application.random.RandomNumberGenerator;
import baseball.application.random.Range;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NextStepRandomNumberGenerator implements RandomNumberGenerator {

    @Override
    public List<Integer> generateUniqueNumberInRange(Range range, int count) {
        return Randoms.pickUniqueNumbersInRange(
                range.startInclusive(),
                range.endInclusive(),
                count
        );
    }
}
