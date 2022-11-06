package baseball;

import java.util.List;

public class PlayGame {
    public int compareNumberForStrike(List<Integer> computerNumber, List<Integer> userNumber){
        int strike = 0;

        for(int digit = 0; digit < computerNumber.size(); digit++){
            if(computerNumber.get(digit) == userNumber.get(digit)){
                computerNumber.remove(digit);
                userNumber.remove(digit);
                strike++;
            }
        }
        return strike;
    }
}
