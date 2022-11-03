package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserAnswer {

    private static final int SIZE = 3;
    private List<Integer> userNumber;


    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public void StringtoList(String userInput){
        check(userInput);
        List<Integer> numbers = new ArrayList<>();
        String[] split = userInput.split("");
        for (String s : split) {
            Integer i = Integer.parseInt(s);
            numbers.add(i);
        }
        userNumber = numbers;
    }
    private void check(String userInput){
        if (!sizeCheck(userInput)){
            throw new IllegalArgumentException();
        }
        if (!isNumber(userInput)){
            throw new IllegalArgumentException();
        }
        if (!duplicateCheck(userInput)){
            throw  new IllegalArgumentException();
        }
    }
    private boolean duplicateCheck(String userInput){
        ArrayList<Character> checkList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++){
            if (checkList.contains(userInput.charAt(i))){
                return false;
            }
            checkList.add(userInput.charAt(i));
        }
        return true;
    }

    private boolean sizeCheck(String userInput){
        if (userInput.length() == SIZE){
            return true;
        }
        return false;
    }

    private boolean isNumber(String userInput){
        for (int i = 0 ; i < userInput.length(); i++){
            if (!Character.isDigit(userInput.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
