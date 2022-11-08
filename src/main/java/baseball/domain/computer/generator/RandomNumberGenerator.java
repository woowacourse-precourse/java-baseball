package baseball.domain.computer.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generateRandomNumbers(
            int startInclusive,
            int endInclusive,
            int count
    ) {
        Set<Integer> randomNumberSet = new LinkedHashSet<>();

        while (randomNumberSet.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            randomNumberSet.add(randomNumber);
        }

        return new ArrayList<>(randomNumberSet);
    }
}
