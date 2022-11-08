package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomNumber {
    private static final int NUMBER = 3;
    private static final int MAXNumber = 9;
    private static final int MINNumber = 1;
    private int[] eachdigit;
    public int[] getDigits() {
        return this.eachdigit;
    }

    public void setRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        this.eachdigit = convertListToIntArray(computerNumber);
    }

    private int[] convertListToIntArray (List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }



}


