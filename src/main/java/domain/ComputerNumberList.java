package domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerNumberList {
    public List<Number> computerNumber;

    public ComputerNumberList() {
        this.computerNumber = getComputerRandomNumber();
    }

    private List<Number> getComputerRandomNumber() {
        List<Number> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < 3) {
            Number randomNumber = new Number(Randoms.pickNumberInRange(1, 9));
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }

    public void generateNewComputerRandomNumber() {
        this.computerNumber = getComputerRandomNumber();
    }
}


