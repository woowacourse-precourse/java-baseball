package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class Valid {

    public static boolean isValidNumList(List<Integer> numList) {
        if (!isNumOneToNine(numList)) {
            return false;
        }else if (!isNumListSizeThree(numList)) {
            return false;
        }else if (!isNotDuplicate(numList)) {
            return false;
        }
        return true;
    }


    private static boolean isNumOneToNine(List<Integer> numList) {
        for (Integer num : numList) {
            if (num < 1 || num > 9) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNotDuplicate(List<Integer> numList) {
        List<Integer> compareList = new ArrayList<>();
        for (Integer num : numList) {
            if(compareList.contains(num)){
                return false;
            }else{
                compareList.add(num);
            }
        }
        return true;
    }

    private static boolean isNumListSizeThree(List<Integer> numList) {
        if (numList.size() != 3) {
            return false;
        } else {
            return true;
        }
    }

}
