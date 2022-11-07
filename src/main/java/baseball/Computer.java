package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;



public class Computer {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int NUMBER_LENGTH = 3;
    private static final String NUMBER_REGEX = "[^0-9]";
    private String number;


    public Computer() {}


    public String getNumber() {
        return this.number;
    }

    public void generateNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        String number = computer.toString().replaceAll(NUMBER_REGEX, "");

        if (!Validator.isValid(number)) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }
}
