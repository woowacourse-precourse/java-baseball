package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private static final int MAX_STRIKE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public String[] number;

    public String[] getNumber() {
        return this.number;
    }

    public void setRandomNumber() {
        Set<String> numberSet = new HashSet<>();
        String[] randomNumber = new String[MAX_STRIKE];

        while (numberSet.size() != MAX_STRIKE) {
            numberSet.add(getSingleRandomNumber());
        }

        numberSet.toArray(randomNumber);
        this.number = randomNumber;
    }

    private String getSingleRandomNumber() {
        return Integer.toString(pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
    }
}
