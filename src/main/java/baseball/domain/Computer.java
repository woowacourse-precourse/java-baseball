package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Computer {
    private ArrayList<Integer> randomNumbers;

    public void setRandomNumbers(ArrayList<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public ArrayList<Integer> getRandomNumbers() {
        return randomNumbers;
    }

}
