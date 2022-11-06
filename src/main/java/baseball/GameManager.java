package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Number;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Integer> computerNumber;

    private void generateComputerNumber() {
        computerNumber = new ArrayList<>();
        Number rule = Number.RULE;

        while (computerNumber.size() != rule.getLength()) {
            int number = Randoms.pickNumberInRange(rule.getMinNumber(), rule.getMaxNumber());

            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }

        }
    }

}
