package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextStepRandomGenerator extends RandomNumberGenerator {

    @Override
    protected List<Integer> generateRandomNumber(int resultSize) {
        List<Integer> result = new ArrayList<>();
        while (result.size() < resultSize) {
            int randomDigit = generateDigit();
            if (isNotAlreadyExist(result, randomDigit)) {
                result.add(randomDigit);
            }
        }
        return Collections.unmodifiableList(result);
    }

    private int generateDigit() {
        return Randoms.pickNumberInRange(RANGE_START_NUMBER, RANGE_END_NUMBER);
    }

    private boolean isNotAlreadyExist(List<Integer> result, int generatedDigit) {
        return !result.contains(generatedDigit);
    }
}
