package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private final static int START = 1;
    private final static int END = 9;

    public List<Integer> generateRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while(randomNumber.size() < 3) {
            int randomDigit = Randoms.pickNumberInRange(START, END);
            isUniqueNumber(randomNumber, randomDigit);
        }
        return randomNumber;
    }

    private void isUniqueNumber(List<Integer> randomNumber, int randomDigit) {
        while(!randomNumber.contains(randomDigit)) {
            randomNumber.add(randomDigit);
        }
    }
}
