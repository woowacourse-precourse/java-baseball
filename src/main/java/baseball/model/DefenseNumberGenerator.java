package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefenseNumberGenerator {
    private static final int DEFENSE_NUMBER_SIZE = 3;

    private DefenseNumberGenerator() {
    }

    public static DefenseNumberGenerator getInstance() {
        return new DefenseNumberGenerator();
    }

    public List<Integer> createDefenseNumbers() {
        List<Integer> defenseNumbers = new ArrayList<>();

        while (defenseNumbers.size() < DEFENSE_NUMBER_SIZE) {
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
