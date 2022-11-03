package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validator {

    public static boolean isValidLength(int number){
        int index = number;

        if (index<100 || index > 999){
            return false;
        }
        return true;
    }
    public static boolean isDupilicated(int number){
        List<Character> checkDulicate = new ArrayList<>();

        for (int len = String.valueOf(number).length(), i= 0; i < len; i++){
            checkDulicate.add(String.valueOf(number).charAt(i));
        }
        Set<Character> chaekSet = new HashSet<>(checkDulicate);
        if (checkDulicate.size()!= chaekSet.size()){
            return false;
        }
        return true;
    }
    public static boolean isNumeric(int number){
        String s = String.valueOf(number);
        char[] c = new char[s.length()];

        for (int len = s.length(), i = 0; i < len; i++){
            c[i] = s.charAt(i);
        }
        for (char check : c){
            if (check >= 48&& c<=57){
                continue;
            } else{
                return false;
            }
        }
        return true;
    }
}
