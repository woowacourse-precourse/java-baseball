package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {

    private static final int MINIMUM_IN_RANGE = 1;
    private static final int MAXIMUM_IN_RANGE = 9;
    private List<Integer> numbers;

    public ComputerNumberGenerator(){
        numbers = new ArrayList<>();
    }

    public int createRandomNumber(){
        return Randoms.pickNumberInRange(MINIMUM_IN_RANGE, MAXIMUM_IN_RANGE);
    }

    public boolean isAlreadyInNumbers(int number){
        return false;
    }

    public void putNumber(int number){
        numbers.add(number);
    }

    public void insertNumber(){

    }

    public void makeThreeDigitNumbers(){

    }

    public int[] returnNumbersToArray(){
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

}
