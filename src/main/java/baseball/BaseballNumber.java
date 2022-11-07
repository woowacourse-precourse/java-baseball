package baseball;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {

    private String computerNumber;

    public BaseballNumber() {
        String number = "";
        while (number.length() < 3) {
            String randomDigit = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!number.contains(randomDigit)) {
                number += randomDigit;
            }
        }
        computerNumber = number;
    }

    public String getNumber() {
        return computerNumber;
    }

    public void setNumber(String number) {
        this.computerNumber = number;
    }

    public MatchResult match(String guessNumber){

        MatchResult matchResult = new MatchResult(0,0);
        return matchResult;
    }
}

