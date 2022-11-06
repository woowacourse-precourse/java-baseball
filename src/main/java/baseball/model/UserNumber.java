package baseball.model;

import java.util.*;

public class UserNumber {
    private List<Integer> userNumbers;

    //입력받고 number로 리스트에 저장하는 기능
    public void setUserNumbers(String input) {
        userNumbers = new ArrayList<>();
        int inputToInt = Integer.parseInt(input);

        while (inputToInt > 0){
            userNumbers.add(inputToInt % 10);
            inputToInt /= 10;
        }
        Collections.reverse(userNumbers);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    //입력받는 부분을 검증할것 1. 숫자인가?
    public boolean isInputDigit(String input){
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                return false;
            }
        }
        return true;
    }

    //입력받는 부분을 검증할것 2. 3글자인가?
    public boolean isInputLengthUnder3(String input){
        return input.length() == 3;
    }

    //입력받는 부분을 검증할것 3. 중복이 아닌가?
    public boolean isInputNotDuplicate(String input){
        List<Character> checkInputArrayList = new ArrayList<>();
        Set<Character> checkDuplicate;

        for(int i = 0; i < input.length(); i++){
            checkInputArrayList.add(input.charAt(i));
        }

        checkDuplicate = new HashSet<>(checkInputArrayList);

        return checkInputArrayList.size() == checkDuplicate.size();
    }

    //입력받는 부분을 검증할것 4. 1에서 9까지의 숫자인가?
    public boolean isBetween1to9(String input){
        for(int i = 0; i < input.length(); i++){
            if(!(Character.getNumericValue(input.charAt(i)) <= 9) ||
                    !(Character.getNumericValue(input.charAt(i)) > 0)){
                return false;
            }
        }
        return true;
    }
}