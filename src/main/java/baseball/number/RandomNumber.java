package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private static final int BALL_NUMBER_LENGTH = 3;

    private final ArrayList<String> randomNumbers = new ArrayList<>();
    public List<String> createRandomNumber() {
        while (randomNumbers.size() < BALL_NUMBER_LENGTH) {
            String number = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (isContainedNumber(number)) {
                randomNumbers.add(number);
            }
        }
        return randomNumbers;
    }

    private boolean isContainedNumber(String number) {
        return !randomNumbers.contains(number);
    }

    public ArrayList<String> getRandomNumbers() {
        return randomNumbers;
    }
}
