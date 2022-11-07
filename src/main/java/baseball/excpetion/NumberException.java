package baseball.excpetion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberException {

    public void validNumberLength(String input){
        if(input.length()!=3){
            throw new IllegalArgumentException();
        }
    }
    public void validContainLetter(String input){
        if(input.matches("^[1-9]")){
            throw new IllegalArgumentException();
        }
    }
    public void validDuplicateNumber(String input){
        Set<Character> number = new HashSet<>();
        for(int i=0; i<3; i++){
            number.add(input.charAt(i));
        }
        if(number.size()!=3){
            throw new IllegalArgumentException();
        }
    }
    public void validOption(String option){
        if(option !="1" || option !="2" ){
            throw new IllegalArgumentException();
        }
    }
}
