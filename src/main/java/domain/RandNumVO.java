package domain;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandNumVO {
    private final List<Integer> randNum;

    public RandNumVO() throws IllegalArgumentException{
        int nums[] = new int[3];
        nums[0] = Randoms.pickNumberInRange(1, 9);
        nums[1] = Randoms.pickNumberInRange(1, 9);
        while(nums[0] != nums[1]) {
            nums[1] = Randoms.pickNumberInRange(1, 9);
        }
        nums[2] = Randoms.pickNumberInRange(1, 9);
        while(nums[2] != nums[1] && nums[2] != nums[0]) {
            nums[2] = Randoms.pickNumberInRange(1, 9);
        }
        this.randNum = List.of(nums[0], nums[1], nums[2]);
    }

    public List<Integer> getRandNum(){
        return randNum;
    }

}
