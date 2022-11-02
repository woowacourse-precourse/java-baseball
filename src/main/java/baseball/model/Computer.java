package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumber;

    Computer() {
        randomNumber = new ArrayList<>();
    }

    public void generateRandomNumber() {
        randomNumber.clear();

        while (randomNumber.size() < 3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
            if (containsDigit(randomDigit)) continue;
            randomNumber.add(randomDigit);
        }
    }

    private boolean containsDigit(int digit) {
        if (randomNumber.contains(digit)) return true;
        return false;
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }
}
