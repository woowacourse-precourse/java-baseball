package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {

    private static final int MINIMUM_IN_RANGE = 1;
    private static final int MAXIMUM_IN_RANGE = 9;
    private static final int NUMBERS_COUNT_LIMIT = 3;
    private List<Integer> numbers;

    public ComputerNumberGenerator(){
        numbers = new ArrayList<>();
    }

    public int[] generateComputerNumber(){
        makeThreeDigitNumbers();
        return returnNumbersToArray();
    }

    int createRandomNumber(){
        return Randoms.pickNumberInRange(MINIMUM_IN_RANGE, MAXIMUM_IN_RANGE);
    }

    boolean isAlreadyInNumbers(int number){
        return numbers.contains(number);
    }

    void putNumber(int number){
        numbers.add(number);
    }

    void insertNumber(){
        int newNumber = createRandomNumber();
        if(!isAlreadyInNumbers(newNumber)) putNumber(newNumber);
    }

    void makeThreeDigitNumbers(){
        while(NUMBERS_COUNT_LIMIT > numbers.size()){
            insertNumber();
        }
    }

    int[] returnNumbersToArray(){
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
