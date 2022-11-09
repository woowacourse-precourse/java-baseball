package baseball;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public static final int MAX_SIZE = 3;

    public static ArrayList<String> createNumber() {
        ArrayList<String> numberList = new ArrayList<>();

        while (numberList.size() < MAX_SIZE) {
            String number = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!numberList.contains(number)) {
                numberList.add(number);
            }
        }
        return numberList;
    }
}
