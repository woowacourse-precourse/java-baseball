package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> randomNumber = new ArrayList<>();

    public void generateRandomNumber() {
        int random = Randoms.pickNumberInRange(1, 9);
        if (!this.randomNumber.contains((random))) {
            this.randomNumber.add(random);
        }
    }

    public int getLengthOfNumber() {
        return this.randomNumber.size();
    }

    public int getComputerNumber() {
        int i = 100;
        int computerNumber = 0;

        for (int number: this.randomNumber) {
            computerNumber += i * number;
            i /= 10;
        }

        return computerNumber;
    }
}
