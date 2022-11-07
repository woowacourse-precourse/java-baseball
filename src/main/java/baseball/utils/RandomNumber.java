package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    public int[] getRandomNumber() {
        int[] numbers = new int[3];

        for (int i =0; i < 3; i ++) {
            numbers[i] = newRandomNumber().get(i);
        }
        return numbers;
    }

    private List<Integer> newRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
