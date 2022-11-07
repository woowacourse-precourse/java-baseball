package baseball.controller;

import java.util.ArrayList;
import java.util.HashSet;
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

    public static boolean isValidRestartAns(String answer) {
        int answerToInt;
        try {
            answerToInt = Integer.parseInt(answer);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (answerToInt == 1 || answerToInt == 2) {
            return true;
        } else {
            return false;
        }
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
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer num : numList) {
            if(hashSet.contains(num)){
                return false;
            }else{
                hashSet.add(num);
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
