package baseball.controller;

import java.util.List;

public class Valid {

    public boolean isValidNumList(List<Integer> numList) {
        if (!isNumOneToNine(numList)) {
            return false;
        }else if (!isNumListSizeThree(numList)) {
            return false;
        }else if (!isNotDuplicateAndNumOneToNine(numList)) {
            return false;
        }
        return true;
    }


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
