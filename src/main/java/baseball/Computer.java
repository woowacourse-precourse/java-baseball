package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public String number;

    public String getNumber() {
        return this.number;
    }

    public void setRandomNumber() {
        Set<Character> numberSet = new HashSet<>();
        StringBuilder randomNumber = new StringBuilder();

        while (numberSet.size() != CNT_NUMBER) {
            numberSet.add(getSingleRandomNumber());
        }

        numberSet.forEach(randomNumber::append);
        this.number = String.valueOf(randomNumber);
    }

    private char getSingleRandomNumber() {
        return (char) (pickNumberInRange(MIN_NUMBER, MAX_NUMBER) + '0');
    }
}
