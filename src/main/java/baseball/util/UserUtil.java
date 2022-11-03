package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserUtil {
    public static String getUserNumberString() {
        String userNumberString = Console.readLine();
        checkUserNumber(userNumberString);
        return userNumberString;
    }

    private static void checkUserNumber(String userNumberString) {
        if(checkNumberLength(userNumberString)){
            throw new IllegalArgumentException();
        }
        if(checkZeroInNumber(userNumberString)){
            throw new IllegalArgumentException();
        }
        if(checkOnlyNumber(userNumberString)){
            throw new IllegalArgumentException();
        }
        if(checkOverlapNumber(userNumberString)){
            throw new IllegalArgumentException();
        }

    }

    private static boolean checkOverlapNumber(String userNumberString) {
        Set<String> set = new HashSet<>(Arrays.asList(userNumberString.split("")));
        if(set.size() == userNumberString.length()){
            return false;
        }
        return true;
    }


    private static boolean checkOnlyNumber(String userNumberString) {
        if(userNumberString.matches("-?\\d+")) {
            return false;
        }
        return true;
    }

    private static boolean checkZeroInNumber(String userNumberString) {
        if(userNumberString.contains("0")){
            return true;
        }
        return false;
    }

    private static boolean checkNumberLength(String userNumberString) {
        if(userNumberString.length() != 3){
            return true;
        }
        return false;
    }


}
