package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public final static int NUMBER_COUNT_TO_CREATED = 3;


    private List<Integer> RandomNumbers = new ArrayList<>();


    public void createRandomNumbers() {
        while (RandomNumbers.size() < NUMBER_COUNT_TO_CREATED) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!RandomNumbers.contains(randomNumber)) {
                RandomNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandomNumbers() {
        return RandomNumbers;
    }
}
