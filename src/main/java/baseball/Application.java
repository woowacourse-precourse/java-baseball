package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static List<Integer> generateRandNum(){
        List<Integer> nums = new ArrayList<>();
        while(nums.size() < 3){
            int randNum = Randoms.pickNumberInRange(1, 9);
            if(!nums.contains(randNum)){
                nums.add(randNum);
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
