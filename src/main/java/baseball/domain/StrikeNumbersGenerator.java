package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class StrikeNumbersGenerator {
    private final static int MIN_STRIKE_NUMBER = 1;
    private final static int MAX_STRIKE_NUMBER = 9;
    private final static int NUMBER_AMOUNT = 3;

    private ArrayList<Integer> strikeNumbers;

    public ArrayList<Integer> generateStrikeNumbers() {
        strikeNumbers = new ArrayList<>();
        for (int countOfNumbers = 0; countOfNumbers < NUMBER_AMOUNT; countOfNumbers++) {
            strikeNumbers.add(pickUniqueNumber());
        }

        return strikeNumbers;
    }

    private int pickUniqueNumber() {
        int uniqueNumber;
        do {
            uniqueNumber = Randoms.pickNumberInRange(MIN_STRIKE_NUMBER, MAX_STRIKE_NUMBER);
        } while (strikeNumbers.contains(uniqueNumber));

        return uniqueNumber;
    }
}
