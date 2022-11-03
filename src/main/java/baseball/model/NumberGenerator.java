package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public List<Integer> createDefenseNumbers() {
        List<Integer> defenseNumbers = new ArrayList<>();

        while (defenseNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addDistinctNumber(defenseNumbers, randomNumber);
        }
        return Collections.unmodifiableList(defenseNumbers);
    }

    private void addDistinctNumber(List<Integer> defenseNumbers, int randomNumber) {
        if (!defenseNumbers.contains(randomNumber)) {
            defenseNumbers.add(randomNumber);
        }
    }
}
