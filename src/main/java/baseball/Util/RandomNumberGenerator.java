package baseball.Util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int NUMBER_SIZE = 3;


    public static List<Integer> generateNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < NUMBER_SIZE){
            int nextNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if(!randomNumbers.contains(nextNumber))
                randomNumbers.add(nextNumber);
        }
        return randomNumbers;
    }

}
