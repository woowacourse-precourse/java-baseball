package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int MINIMUM_VALUE_OF_NUMBER = 1;
    private static final int MAXIMUM_VALUE_OF_NUMBER = 9;
    private static final int LIST_LIMIT = 3;
    List<Integer> numbers;

    public Computer(){
        numbers = new ArrayList<>();
    }

    public int createRandomNumber(){
        return Randoms.pickNumberInRange(MINIMUM_VALUE_OF_NUMBER, MAXIMUM_VALUE_OF_NUMBER);
    }

    public void putNumber(int number){
        numbers.add(number);
    }

    public boolean isAlreadyInNumbers(int number){
        return numbers.contains(number);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public void insertNumber(){
        int number = createRandomNumber();
        if(!isAlreadyInNumbers(number)) putNumber(number);
    }

    public void makeThreeDigitNumber(){
        for(int numberCount = 0; numberCount < LIST_LIMIT; numberCount++){
            insertNumber();
        }
    }


}
