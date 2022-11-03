package baseball.Random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {

    public static final int NUMBER_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public static String generateAnswerNumber(){
        String result = "";
        Set<Integer> nums = new HashSet<>();

        while (nums.size() < NUMBER_SIZE){
            int rand_num = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            nums.add(rand_num);
        }
        for (Integer num: nums) result += Integer.toString(num);

        return result;
    }
}
