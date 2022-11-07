package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

import static baseball.utils.Constants.*;

public class RandomNumberGenerator {
    public static ArrayList<Integer> getRandomNumberList() {
        ArrayList<Integer> randomNumberList = new ArrayList<Integer>();
        while (randomNumberList.size() < MAX_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }
}
