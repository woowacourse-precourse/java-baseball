package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private static final int NUMBER_LENGTH = 3;
    private static final int NUMBER_RANGE_START = 1;
    private static final int NUMBER_RANGE_END = 9;

    private ArrayList<Integer> number = new ArrayList<Integer>(NUMBER_LENGTH);

    public void setRandomNumber() {
        while (number.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }
    public boolean checkNumbers(ArrayList<Integer> listOfNumbers) {
        if (listOfNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("세자리 수가 아닙니다.");
        }
        Set<Integer> setOfNumbers = new HashSet<Integer>(listOfNumbers);
        if (setOfNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("중복된 수를 입력하셨습니다.");
        }
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (listOfNumbers.get(i) < NUMBER_RANGE_START || NUMBER_RANGE_END < listOfNumbers.get(i)) {
                throw new IllegalArgumentException("범위 밖의 수를 입력하셨습니다.");
            }
        }
        return true;
    }
}
