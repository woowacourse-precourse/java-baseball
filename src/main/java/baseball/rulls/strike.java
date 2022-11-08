package baseball.rulls;

public class strike {
    public static boolean isStrike(int computerNumber ,int userNumber){
        if(computerNumber == userNumber) {
            return true;
        }
        return false;
    }
}
