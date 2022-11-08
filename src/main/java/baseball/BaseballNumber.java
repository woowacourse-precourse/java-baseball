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
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < 3; i++){
            if(guessNumber.charAt(i) == computerNumber.charAt(i)){
                strike++;
                continue;
            }
            if(computerNumber.contains(guessNumber.substring(i,i+1))){
                ball++;
            }
        }
        MatchResult matchResult = new MatchResult(ball,strike);
        return matchResult;
    }
}

