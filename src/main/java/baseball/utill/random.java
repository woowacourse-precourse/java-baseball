package baseball.utill;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class random {
    private static List<Integer> randomNumbers;
    
    public void computerNumber() {
        this.randomNumbers = makeRandomNumber();
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public List<Integer> randomNumbers() {
        return Collections.unmodifiableList(randomNumbers);
    }
}
