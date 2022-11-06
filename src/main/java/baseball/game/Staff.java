package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Rules.END_NUMBER;
import static baseball.constant.Rules.PICK_COUNT;
import static baseball.constant.Rules.START_NUMBER;

public class Staff {
    public List<Integer> getTargetNumbers() {
        List<Integer> targetNumbers = new ArrayList<>();

        while (targetNumbers.size() < PICK_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

            if (!targetNumbers.contains(randomNumber)) {
                targetNumbers.add(randomNumber);
            }
        }

        return targetNumbers;
    }
}
