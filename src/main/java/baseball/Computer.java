package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {


    private static Computer instance;

    private final List<Number> computerNumbers = new ArrayList<>();

    private Computer () {}

    public static Computer getComputer() {
        if (instance == null) {
            instance = new Computer();
        }
        return instance;
    }

    public void pickNewRandomNumbers() {
        computerNumbers.clear();
        for (int index = 0; index < 3; index++) {
            computerNumbers.add(pickNewRandomNumber());
        }
    }

    private Number pickNewRandomNumber() {
        Number newRandomNumber;
        do {
            newRandomNumber = Number.createRandomNumber();
        } while (computerNumbers.contains(newRandomNumber));
        return newRandomNumber;
    }

    public Number findComputerNumber(int index) {
        return computerNumbers.get(index);
    }
}
