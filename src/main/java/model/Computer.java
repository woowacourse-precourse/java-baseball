package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static List<Integer> randomNumber = new ArrayList<>();

    public static void generateRandomNumber() {
        int random = Randoms.pickNumberInRange(1, 9);
        if (!randomNumber.contains(random)) {
            randomNumber.add(random);
        }
    }

    public static int getLengthOfNumber() {
        return randomNumber.size();
    }
}
