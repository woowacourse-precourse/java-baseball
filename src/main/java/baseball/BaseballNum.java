package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNum {

    private final int[] indexes = new int[10];

    private final int[] nums = new int[3];

    public BaseballNum() {
        int index = 1;
        while (index <= 3) {
            int nextNum = Randoms.pickNumberInRange(1, 9);
            if (indexes[nextNum] == 0) {
                nums[index - 1] = nextNum;
                indexes[nextNum] = index++;
            }
        }
    }

    public int getFirst() {
        return nums[0];
    }

    public int getSecond() {
        return nums[1];
    }

    public int getThird() {
        return nums[2];
    }

    public int getIndex(int num) {
        try {
            return indexes[num];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

}
