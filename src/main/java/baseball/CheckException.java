package baseball;

public class CheckException {
    static final char ONE = 81;
    static final char NINE = 89;

    public static boolean checkPlayerNumber(int playerNumber){
        String playerStringNumber = String.valueOf(playerNumber);
        char[] playerNumberArray = playerStringNumber.toCharArray();
        boolean isNumber;
        for(char number : playerNumberArray){
            isNumber = checkNumber(number);
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
