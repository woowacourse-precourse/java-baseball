package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Computer {
    static final int FIRST_NUM = 1;
    static final int LAST_NUM = 9;
    static final int NUMBER_LENGTH = 3;

    public List<Integer> makeComputerNumber() {
        List<Integer> computerNumber = makeRandomNumber();

        while (true) {
            if (validateNumber(computerNumber)) {
                return computerNumber;
            } else {
                computerNumber = makeRandomNumber();
            }
        }
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> randomNum = new ArrayList<>();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            randomNum.add(Randoms.pickNumberInRange(FIRST_NUM, LAST_NUM));
        }

        return randomNum;
    }

    public boolean validateNumber(List<Integer> num) {
        HashSet<Integer> setNum = Sets.newHashSet(num);

        if (setNum.size() == num.size()) {
            return true;
        } else {
            return false;
        }
    }
}