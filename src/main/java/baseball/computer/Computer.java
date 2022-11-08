package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private static final int NUMBER_OF_TRIAL=3;
    private static final int RANGE_START_NUMBER=1;
    private static final int RANGE_END_NUMBER=9;
    public List<Integer> digits = new ArrayList<>();
    public int getNumberPosition(int number){
        return digits.indexOf(number);
    }
    public List<Integer> getDigits(){
        return Collections.unmodifiableList(digits);
    }
    public void createRandomNumbers(){

        List<Integer> opponentNumber = new ArrayList<>();
        while(opponentNumber.size() < NUMBER_OF_TRIAL){
            int randomNumber = Randoms.pickNumberInRange(RANGE_START_NUMBER, RANGE_END_NUMBER);
            if (!opponentNumber.contains(randomNumber)) {
                opponentNumber.add(randomNumber);
            }
        }
        digits=opponentNumber;
    }
}
