package baseball;

import java.util.*;

public class InputChecker {
    public boolean checkLength(String input) throws IllegalArgumentException{
        if(input.length()!=3){
            throw new IllegalArgumentException();
        }
        return true;
    }
    public boolean checkStringIsDigit(String input) throws IllegalArgumentException{
        for(int i=0; i<input.length(); i++){
            if(! Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
    public boolean checkDuplication(String input) throws IllegalArgumentException{
        String[] s=input.split("");
        List<String> inputList=new ArrayList<String>(Arrays.asList(s));
        for(int i=0; i< inputList.size(); i++){
            if(Collections.frequency(inputList, inputList.get(i))>1) {
                throw new IllegalArgumentException();
            }
        }

        return true;
    }
    public boolean checkInput(String input) throws IllegalArgumentException{
        if(checkLength(input) && checkStringIsDigit(input) && checkDuplication(input)){
            return true;
        }
        return false;
    }
}
