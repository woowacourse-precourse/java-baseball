package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {

    public int[] getRandomNumber(int startNum, int endNum) {
        int[] numbers = new int[3];

        for (int i =0; i < 3; i ++) {
            numbers[i] = newRandomNumber(startNum, endNum).get(i);
        }
        return numbers;
    }

    private List<Integer> newRandomNumber(int startNum, int endNum) {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = pickNumberInRange(startNum, endNum);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
