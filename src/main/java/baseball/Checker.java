package baseball;

import constant.Texts;

import java.util.List;

public class Checker {
    public void checkLegalNumber(String number) throws IllegalArgumentException {
        if (!this.isIntegerNumeric(number)) {
            throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL_MISMATCHING+Texts.USER_INPUT_ILLEGAL);
        }
        if (!this.isNumberDigitLegal(number)) {
            throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL_DIGIT+Texts.USER_INPUT_ILLEGAL);
        }
        if (this.isNumberDuplicated(number)) {
            throw new IllegalArgumentException(Texts.USER_INPUT_ILLEGAL_DUPLICATED+Texts.USER_INPUT_ILLEGAL);
        }
    }
    public boolean isIntegerNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean isNumberDigitLegal(String number) {
        if (number.length() > 3) {
            return false;
        }
        return true;
    }
    public boolean isNumberDuplicated(String number) {
        String[] digits = number.split("");
        for(int i=0;i<digits.length-1;i++) {
            for(int j=i+1;j<digits.length;j++){
                if(digits[i].equals(digits[j])){
                    return true;
                }
            }
        }
        return false;
    }
    public int checkResult(List<Integer> target, List<Integer> input) {
        int result = 0;
        return result;
    }

    public int isStrike(int target, int input) {
        int result = 0;
        return result;
    }

    public int isBall(int target, List<Integer> input) {
        int result = 0;
        return result;
    }
}
