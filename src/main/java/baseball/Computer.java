package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    static final int NUMBER_LENGTH = 3;

    int randomNumber;

    public Computer() {
    }

    public void setRandomNumber() {
        List<String> digitsList = new ArrayList<>();
        while(digitsList.size() < NUMBER_LENGTH) {
            String digit = String.valueOf(Randoms.pickNumberInRange(1,9));
            if(!digitsList.contains(digit)) {
                digitsList.add(digit);
            }
        }
        randomNumber = Integer.parseInt(String.join("", digitsList));
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
