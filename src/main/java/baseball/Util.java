package baseball;

import static baseball.Constant.*;

public class Util {
    public static void isWeirdSize(String inputNumber) {
        if(inputNumber.length() != GAMEPLAY_SIZE){
            throw new IllegalArgumentException();
        }
    }
    public static void isNumber(String inputNumber) {
        for(int i=0; i<inputNumber.length();i++){
            char number = inputNumber.charAt(i);
            char startNum = (char)(MIN_NUM+'0');
            char endNum = (char)(MAX_NUM+'0');
            if(number >= startNum && number <= endNum) {}
            else {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void isSameEachNumber(String inputNumber) {
        for(int i=0; i<inputNumber.length()-1;i++) {
            String eachNumber = inputNumber.substring(i+1);
            if(eachNumber.contains(Character.toString(inputNumber.charAt(i)))) {
                throw new IllegalArgumentException();
            }
        }
    }
}
