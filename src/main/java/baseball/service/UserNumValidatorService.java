package baseball.service;

import java.util.*;

import static baseball.controller.BaseballController.NUM_LENGTH;

public class UserNumValidatorService {
    public static List<Integer> validator(String input) throws IllegalArgumentException{
        if(isThreelen(input) && isNotDuplicated(input) && isOneNineInt(input)){
            List<Integer> num = new ArrayList<>();

            for(int i=0; i<NUM_LENGTH; i++){
                num.add(input.charAt(i)-'0');
            }

            return num;
        }
        else
            throw new IllegalArgumentException();
    }


    public static boolean isThreelen(String input){
        return input.length() == 3;
    }

    public static boolean isNotDuplicated(String input){
        ArrayList<String> listInput = new ArrayList<>(Arrays.asList(input.split("")));
        Set<String> inputSet = new HashSet<>(listInput);
        return inputSet.size() == listInput.size();
    }


    public static boolean isOneNineInt(String input){
        for(int i=0; i < input.length(); i++){
            char n = input.charAt(i);
            if(n == '0' || !Character.isDigit(n))
                return false;
        }
        return true;
    }
}
