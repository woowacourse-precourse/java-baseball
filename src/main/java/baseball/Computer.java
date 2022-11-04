package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public final static int NUMBER_COUNT_TO_CREATED = 3;


    private List<Integer> randomNumbers = new ArrayList<>();


    public void createRandomNumbers() {
        while (randomNumbers.size() < NUMBER_COUNT_TO_CREATED) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }

    public void clearRandomNumbers() {
        randomNumbers.clear();
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
