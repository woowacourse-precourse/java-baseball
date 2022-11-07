package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MINIMUM_VALUE_OF_NUMBER = 1;
    private static final int MAXIMUM_VALUE_OF_NUMBER = 9;
    private static final int LIST_LIMIT = 3;
    private List<Integer> numbers;

    public Computer(){
        numbers = new ArrayList<>();
    }

    private int createRandomNumber(){
        return Randoms.pickNumberInRange(MINIMUM_VALUE_OF_NUMBER, MAXIMUM_VALUE_OF_NUMBER);
    }

    private void putNumber(int number){
        numbers.add(number);
    }

    private boolean isAlreadyInNumbers(int number){
        return numbers.contains(number);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    private void insertNumber(){
        int number = createRandomNumber();
        if(!isAlreadyInNumbers(number)) putNumber(number);
    }

    public void makeThreeDigitNumber(){
        while(numbers.size() < LIST_LIMIT){
            insertNumber();
        }
    }
}
