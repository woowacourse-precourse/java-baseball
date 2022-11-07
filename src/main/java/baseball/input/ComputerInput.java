package baseball.input;

import baseball.validatioon.Validation;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.NUMBER_LENGTH;

public class ComputerInput {
    public List<Integer> getNumberList() {
        ArrayList<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < NUMBER_LENGTH) {
            int randomNumber = getValidRandomNumber(computerNumberList);
            computerNumberList.add(randomNumber);
        }
        return computerNumberList;
    }

    public static int getValidRandomNumber(List<Integer> lst) {
        int pickNumber;
        do {
            pickNumber = Randoms.pickNumberInRange(1, 9);
        } while (!Validation.isValidNumber(pickNumber, lst));
        return pickNumber;
    }

}
