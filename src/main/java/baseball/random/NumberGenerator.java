package baseball.random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

import static baseball.utils.BaseballConstants.*;

public class NumberGenerator {



    public static String generateAnswerNumber(){
        String result = "";
        Set<Integer> nums = new HashSet<>();

        while (nums.size() < BALL_NUMBER){
            int rand_num = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            nums.add(rand_num);
        }
        for (Integer num: nums) result += Integer.toString(num);

        return result;
    }
}
