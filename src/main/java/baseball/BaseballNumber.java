package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {

    private String computerNumber;

    public String getNumber() {
        return this.computerNumber;
    }

    public void setNumber(String number) {
        this.computerNumber = number;
    }

    public void makeRandomNumber() {
        StringBuilder number = new StringBuilder();
        while (number.length() < 3) {
            String randomDigit = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (!number.toString().contains(randomDigit)) {
                number.append(randomDigit);
            }
        }
        this.computerNumber = number.toString();
    }

    public MatchResult match(String guessNumber) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (guessNumber.charAt(i) == this.computerNumber.charAt(i)) {
                strike++;
                continue;
            }
            if (this.computerNumber.contains(guessNumber.substring(i, i + 1))) {
                ball++;
            }
        }
        return new MatchResult(ball, strike);
    }
}

