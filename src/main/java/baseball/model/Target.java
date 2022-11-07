package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Target {
    private static List<Integer> targetNumberList = new ArrayList<>(Arrays.asList(0, 0, 0));

    public static void reset() {
        setTargetIntoZeroList();
        for (int indexOfList = 0; indexOfList < 3; indexOfList++) {
            setOneNumber(indexOfList);
        }
    }

    public static List<Integer> get() {
        return targetNumberList;
    }

    static void setTargetIntoZeroList() {
        for (int i = 0; i < 3; i++) {
            targetNumberList.set(i, 0);
        }
    }

    static void setOneNumber(int indexOfList) {
        boolean isInTargetNumberList = true;
        int randomNumber = 0;
        while (isInTargetNumberList) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            isInTargetNumberList = checkIsNumberInTargetList(randomNumber);
        }
        targetNumberList.set(indexOfList, randomNumber);
    }

    static boolean checkIsNumberInTargetList(int number) {
        return targetNumberList.contains(number);
    }
}
