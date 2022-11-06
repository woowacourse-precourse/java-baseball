package baseball.input;

import baseball.validatioon.Validation;

import java.util.ArrayList;
import java.util.List;

public class ComputerInput {
    public List<Integer> getNumberList() {
        ArrayList<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randomNumber = Validation.getValidRandomNumber(computerNumberList);
            computerNumberList.add(randomNumber);
        }
        return computerNumberList;
    }

}
