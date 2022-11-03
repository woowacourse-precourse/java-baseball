package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class BaseballNumber {
    ArrayList<Integer> numbers = new ArrayList<>();

    public void setNumbersByRandom(){
        numbers.clear();
        while(numbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
    }

    public void setNumbers(String numbersStr){
        numbers.clear();
        for(int i = 0; i < 3; i++){
            int number = Integer.valueOf(numbersStr.charAt(i));
            numbers.add(number);
        }
    }

    public boolean is3Digit(String numbersStr){
        if(numbersStr.length() == 3){
            return true;
        }
        return false;
    }

    public boolean isAllInteger(String numbersStr){
        for(int i = 0; i < numbersStr.length(); i++){
            if('0' > numbersStr.charAt(i) || numbersStr.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }

    public boolean isNonZero(String numbersStr){
        for(int i = 0; i < numbersStr.length(); i++){
            if(numbersStr.charAt(i) == 0){
                return false;
            }
        }
        return true;
    }
}
