package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class Computer {
    final static int NUMBER_LENGTH = 3;
    private ArrayList<Integer> randomNumbers = new ArrayList<>(NUMBER_LENGTH);

    Computer() {
        while(randomNumbers.size() < NUMBER_LENGTH) {
            Integer newRandomNumber = pickRandomNumber();
            if (!has(newRandomNumber)) {
                randomNumbers.add(newRandomNumber);
            }
        }
    }

    public ArrayList<Integer> getRandomNumbers() {

        return this.randomNumbers;
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