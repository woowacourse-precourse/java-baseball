package baseball;

public class CheckException {
    static final char ONE = 81;
    static final char NINE = 89;

    public static boolean checkNumberLength(String number){
        //1자리수일때 1이나 2인지 따로 또 체크
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

    public static void check(String number){
        //if(number == "1") Restart.
        //if(number == "2")

        if(checkNumberLength(number)){
            if(!checkNumber(number)){
                throw new IllegalArgumentException();
            }
        }
        else{
            throw new IllegalArgumentException();
        }
    }

}
