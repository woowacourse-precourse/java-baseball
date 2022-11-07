package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateRandomNumber {
    private static List<BaseballNumber> randomNumbers;

    public CreateRandomNumber() {
        this.randomNumbers = extractNumbers();
    }

    public List<BaseballNumber> extractNumbers() {
        List<BaseballNumber> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() != 3) {
            BaseballNumber randomNumber = new BaseballNumber(Randoms.pickNumberInRange(1, 9));
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public List<BaseballNumber> randomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
