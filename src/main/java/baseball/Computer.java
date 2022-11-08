package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    final static int NUMBER_LENGTH = 3;
    private ArrayList<String> randomNumbers = new ArrayList<>();

    Computer() {
        while (randomNumbers.size() < NUMBER_LENGTH) {
            Integer newRandomNumber = pickRandomNumber();
            if (!has(newRandomNumber)) {
                randomNumbers.add(Integer.toString(newRandomNumber));
            }
        }
    }

    public String getStringRandomNumbers() {
        return String.join("", randomNumbers);
    }

    private boolean has(Integer number) {
        if (this.randomNumbers.contains(number)) {
            return true;
        }
        return false;
    }

    private static Integer pickRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
