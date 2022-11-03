package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class RandomNumbers {
    int numberLength;
    public RandomNumbers(){
        this(3);
    }

    public RandomNumbers(int numberLength) {
        this.numberLength = numberLength;
    }
    private List<Integer> computerNumbers = new ArrayList<>(numberLength);

    public List<Integer> getComputerNumbers() {
        fillListRandomNumber();

        return computerNumbers;
    }

    private void fillListRandomNumber() {
        while (computerNumbers.size() < numberLength) {
            addSoloNumber();
        }
    }

    private void addSoloNumber() {
        int rawRandomNumber = Randoms.pickNumberInRange(1,9);

        if (computerNumbers.contains(rawRandomNumber)) {
            return;
        }

        computerNumbers.add(rawRandomNumber);
    }
}
