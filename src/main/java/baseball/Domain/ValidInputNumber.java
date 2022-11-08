package baseball.Domain;


import baseball.Util.Constant;
import baseball.Util.ValidHandler;

import java.util.HashSet;
import java.util.Set;

public class ValidInputNumber {

    private static String inputUserNumber = null;
    private boolean isValid = false;

    public ValidInputNumber(String inputUserNumber) {
        this.inputUserNumber = inputUserNumber;
        this.isValid = isValid;
    }

    public static boolean setIsValidString() {
        if(!isThereZero()) {
            return false;
        }
        if(!isItAllSameNumber()) {
            return false;
        }

        if(!isValidArrayNumberRange()) {
            return false;
        }
        if(ValidHandler.DuplicatedNumber(inputUserNumber)) {
            return false;
        }
        return true;
    }

    public static boolean isThereZero() throws IllegalArgumentException {
        if(inputUserNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
        return true;
    }


    public static boolean isItAllSameNumber() throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for(int index = 0; index < inputUserNumber.length(); index++) {
            set.add(inputUserNumber.charAt(index));
        }
        if(set.size() != inputUserNumber.length()) {
            throw new IllegalArgumentException();
        }
        return true;
    }


    public static boolean isValidArrayNumberRange() throws IllegalArgumentException {
        if(Integer.parseInt(inputUserNumber) > Constant.MAX_NUM_RANGE || Integer.parseInt(inputUserNumber) < Constant.MIN_NUM_RANGE) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
