package baseball.controller;

import java.util.List;

public class Valid {

    private boolean isNumOneToNine(int num) {
        if (num >= 1 && num <= 9) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isNotDuplicateAndNumOneToNine(List<Integer> numList) {
        for (Integer num : numList) {
            if(numList.contains(num)){
                return false;
            }
        }
        return true;
    }

}
