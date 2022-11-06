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



}
