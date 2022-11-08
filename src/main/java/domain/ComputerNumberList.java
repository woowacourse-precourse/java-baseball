package domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumberList {
    private static final int NUMBER_SIZE = 3;
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;

    private List<Number> computerNumber;

    public ComputerNumberList() {
        generateNewComputerRandomNumber();
    }

    private List<Number> newComputerRandomNumber() {
        List<Number> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < NUMBER_SIZE) {
            Number randomNumber = new Number(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    public void generateNewComputerRandomNumber() {
        this.computerNumber = newComputerRandomNumber();
    }

    public List<Number> getComputerNumber() {
        return computerNumber;
    }
}


