package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
    private static final int RANDOM_NUMBERS_LENGTH = 3;

    public static List<Integer> createRandomIntListWithoutDuplication(int startNum, int endNum) {
        List<Integer> randomNumberList = new ArrayList<>();
        int randomNumber;
        while (randomNumberList.size() < RANDOM_NUMBERS_LENGTH){
            randomNumber = Randoms.pickNumberInRange(startNum, endNum);
            if(!randomNumberList.contains(randomNumber)){
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }
}
