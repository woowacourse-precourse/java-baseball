package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(makeAnswer());
    }

    public static String makeAnswer(){
        String result = "";
        List<Integer> nums = new ArrayList<Integer>();

        while (true){
            if (nums.size() == 3) break;
            int rand_num = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(rand_num)) nums.add(rand_num);
        }
        for (Integer num: nums) result += Integer.toString(num);

        return result;
    }
}
