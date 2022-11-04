package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Number {

    private static List<Integer> randomNumber;

    public Number() {
        randomNumber = new ArrayList<>();
    }

    public List<Integer> getEnterNumber() {
        return this.getEnterNumber();
    }

    public List<Integer> getRandomNumber() {
        return this.getRandomNumber();
    }
    public static void getRandomNumberList() {
        while(randomNumber.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(!randomNumber.contains(randomNum)) {
                randomNumber.add(randomNum);
            }
        }
    }

}
