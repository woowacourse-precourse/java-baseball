package utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class RandomNumbers {
    int numberLength;
    RandomNumbers(){
        this(3);
    }

    RandomNumbers(int numberLength) {
        this.numberLength = numberLength;
    }
    private List<Integer> computerNumbers = new ArrayList<>(numberLength);

    private void addSoloNumber() {
        int rawRandomNumber = Randoms.pickNumberInRange(1,9);

        if (computerNumbers.contains(rawRandomNumber)) {
            return;
        }

        computerNumbers.add(rawRandomNumber);
    }
}
