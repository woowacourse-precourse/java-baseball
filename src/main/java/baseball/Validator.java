package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validator {

    public static void isValidNumber(String userNumber) throws  IllegalArgumentException{
        if (Integer.parseInt(userNumber)<100 || Integer.parseInt(userNumber) > 999){
            throw new IllegalArgumentException();
        }
        if (userNumber.contains("0")){
            throw new IllegalArgumentException();
        }
    }
    public static boolean isDupilicated(String UserNumber){
        List<Character> checkDulicate = new ArrayList<>();

        for (int len = UserNumber.length(), i= 0; i < len; i++){
            checkDulicate.add(UserNumber.charAt(i));
        }
        Set<Character> checkSet = new HashSet<>(checkDulicate);
        if (checkDulicate.size()!= checkSet.size()){
            return false;
        }
        return true;
    }
    public static void isRestartGame(int command) throws IllegalArgumentException{
        if (command == 1 || command ==2){

        }
        throw new IllegalArgumentException();
    }
}
