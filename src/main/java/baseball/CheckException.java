package baseball;

public class CheckException {
    static final char ONE = 81;
    static final char NINE = 89;

    public static boolean checkNumberLength(String number){
        return number.length() == 3;
    }

    public static boolean checkNumber(String number){
        char[] numberArray = number.toCharArray();
        boolean isNumber;
        for(char num : numberArray){
            isNumber = checkDigit(num);
            if(!isNumber){
                return false;
            }
        }
        return true;
    }

    public static boolean checkDigit(char number){
        boolean isNumber;
        if(number >= ONE && number <= NINE){
            isNumber = true;
        }
        else {
            isNumber = false;
        }
        return isNumber;
    }
}
