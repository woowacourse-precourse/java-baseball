package baseball.utill;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Random {
    private static List<BaseBallNumber> randomNumbers;
    
    public Random() {
        this.randomNumbers = makeRandomNumber();
    }

    private List<BaseBallNumber> makeRandomNumber() {
        List<BaseBallNumber> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            BaseBallNumber randomNumber = new BaseBallNumber(Randoms.pickNumberInRange(1, 9));
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public List<BaseBallNumber> randomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
