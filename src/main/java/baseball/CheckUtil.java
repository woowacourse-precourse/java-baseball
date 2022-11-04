package baseball;

import static baseball.Constant.*;
public class CheckUtil {

    public void checkIsValidDigit(String input){
        for(char c:input.toCharArray()){
            int c_int = Character.getNumericValue(c);
            if(c_int<1 || c_int>9){
                throw new IllegalArgumentException(invalidNumberMessage);
            }
        }
    }

    public void checkIsValidLength(int length){
        if(length != 3){
            throw new IllegalArgumentException(invalidLengthMessage);
        }
    }

    public void checkIsDuplicated(String input){
        char firstChar = input.charAt(0);
        char secondChar = input.charAt(1);
        char thirdChar = input.charAt(2);
        if(firstChar == secondChar || secondChar == thirdChar || firstChar == thirdChar){
            throw new IllegalArgumentException(duplicatedNumberMessage);
        }
    }
}
