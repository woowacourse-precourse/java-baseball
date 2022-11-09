package baseball.input;

import static baseball.Constants.NUMBER_LENGTH;

import baseball.validatioon.Validation;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerInput {
    public List<Integer> getNumberList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < NUMBER_LENGTH) {
            int randomNumber = getValidRandomNumber(computerNumberList);
            computerNumberList.add(randomNumber);
        }
        return computerNumberList;
    }

    private static int getValidRandomNumber(List<Integer> lst) {
        int pickNumber;
        do {
            pickNumber = Randoms.pickNumberInRange(1, 9);
        } while (!Validation.isValidNumber(pickNumber, lst));
        return pickNumber;
    }

}
