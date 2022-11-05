package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {

    static final int NUMBER_LENGTH = 3;

    int randomNumber;

    public Computer() {
    }

    public void setRandomNumber() {
        Set<Integer> randomDigitSet = new HashSet<>();

        while(true) {
            int randomDigit = Randoms.pickNumberInRange(1,9);
            randomDigitSet.add(randomDigit);
            if(randomDigitSet.size() == NUMBER_LENGTH) {
                break;
            }
        }

        String randomNumberString ="";
        for(int randomDigit: randomDigitSet) {
            randomNumberString += String.valueOf(randomDigit);
        }



        randomNumber = Integer.parseInt(randomNumberString);

    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
