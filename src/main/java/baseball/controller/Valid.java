package baseball.controller;

import java.util.List;

public class Valid {


    private boolean isNumOneToNine(List<Integer> numList) {
        for (Integer num : numList) {
            if (num < 1 || num > 9) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotDuplicateAndNumOneToNine(List<Integer> numList) {
        for (Integer num : numList) {
            if(numList.contains(num)){
                return false;
            }
        }
        return true;
    }

    private boolean isNumListSizeThree(List<Integer> numList) {
        if (numList.size() != 3) {
            return false;
        } else {
            return true;
        }
    }

}
