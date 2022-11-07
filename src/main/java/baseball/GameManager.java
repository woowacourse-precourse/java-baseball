package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import constants.Rule;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Integer> computerNumber;

    private void generateComputerNumber() {
        computerNumber = new ArrayList<>();
        Rule number = Rule.NUMBER;

        while (computerNumber.size() != number.getLength()) {
            int randomNumber = Randoms.pickNumberInRange(number.getMin(), number.getMax());

            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }

        }
    }

}
