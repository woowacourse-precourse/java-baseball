package baseball;

public class CheckException {
    static final char ONE = 81;
    static final char NINE = 89;

    public static boolean checkNumber(int number){
        String playerStringNumber = String.valueOf(number);
        char[] playerNumberArray = playerStringNumber.toCharArray();
        boolean isNumber;
        for(char num : playerNumberArray){
            isNumber = checkNumber(num);
            if(!isNumber){
                return false;
            }
        }
        return true;
    }

    public static boolean checkNumber(char number){
        boolean isNumber = true;
        if(number >= ONE && number <= NINE){
            isNumber = true;
        }
        else {
            isNumber = false;
        }
        return isNumber;
    }
}
