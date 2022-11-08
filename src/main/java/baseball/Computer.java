package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;

public class Computer {

    private static final int NumberLength = 3;
    private static String computerNumber;

    Computer() {
    }

    public void setComputerNumber() {
        computerNumber = getRandomDifferentNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public String getRandomDifferentNumber() {
        String number = "";
        HashSet<Integer> differentNumSet = new HashSet<>();
        for (int i = 0; i < NumberLength; i++) {
            int newNum = getRandomNumber();
            if (differentNumSet.contains(newNum)) {
                i--;
                continue;
            }
            differentNumSet.add(newNum);
            number += Integer.toString(newNum);
        }
        return number;
    }
}
