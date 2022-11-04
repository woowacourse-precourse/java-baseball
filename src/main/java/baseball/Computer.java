package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;



public class Computer {
    static final int MIN_RANGE = 1;
    static final int MAX_RANGE = 9;
    static final int NUMBER_LENGTH = 3;
    private String number;


    public Computer() {
        try {
            number = this.generateNumber();
        } catch (Exception e) {
            throw e;
        }
    }


    public String getBaseballNumber() {
        return number;
    }

    public String generateNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        String number = computer.toString().replaceAll("[^0-9]", "");

        if (!BaseballNumber.isValid(number)) {
            throw new IllegalArgumentException();
        }

        return number;
    }
}
