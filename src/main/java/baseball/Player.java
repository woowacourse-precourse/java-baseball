package baseball;

import java.util.*;

public class Player {
    protected static List<Integer> Answer;

    public static boolean isInteger(String s){
        try  {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isPositiveNumber(String s){
        boolean result = true;
        if (Integer.parseInt(s) <= 0){
            result = false;
        }
        return result;
    }
}
