package baseball.Random;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {

    public static String generateAnswerNumber(){
        String result = "";
        Set<Integer> nums = new HashSet<>();

        while (nums.size() < 3){
            int rand_num = Randoms.pickNumberInRange(1, 9);
            nums.add(rand_num);
        }
        for (Integer num: nums) result += Integer.toString(num);

        return result;
    }


}
