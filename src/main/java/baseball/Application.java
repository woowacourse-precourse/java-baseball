package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    private boolean isNumber(String str){
        if(str == null || str.isEmpty())
            return false;
        long numOfDigit = str.chars()
            .mapToObj(ch -> (char)ch)
            .filter(Character::isDigit)
            .count();
        return numOfDigit == str.length();
    }

    private boolean is3DigitNumber(String str){
        return isNumber(str) && str.length() == 3;
    }

    private boolean hasUniqueCharacter(String str){
        if(str == null || str.isEmpty())
            return false;
        long numOfUniqueCharacter = str.chars()
                .distinct()
                .count();
        return numOfUniqueCharacter == str.length();
    }

    private void validateUserInput(String userInput, boolean gameover){
        if(gameover){
            if(!Objects.equals(userInput,"1") && !Objects.equals(userInput,"2")){
                throw new IllegalArgumentException("userInput should be 1 or 2.");
            }
        } else{
            if(!is3DigitNumber(userInput) && hasUniqueCharacter(userInput)){
                throw new IllegalArgumentException("userInput should be 3 digit number.");
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
