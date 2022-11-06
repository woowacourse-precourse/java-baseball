package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Function {
    public static void addRandomNumber(List<Integer> list) {
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if(!list.contains(randomNumber)){
            list.add(randomNumber);
        }
    }

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

    public static List<Integer> changeStringtoList(String s){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            result.add(Character.getNumericValue(s.charAt(i)));
        }
        return result;
    }

    public static boolean isDifferentNumbers(List<Integer> list){
        boolean result = true;
        Set<Integer> set = new HashSet<>(list);
        if(set.size() != list.size()){
            result = false;
        }
        return result;
    }
}
