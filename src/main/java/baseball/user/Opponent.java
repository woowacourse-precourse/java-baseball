package baseball.user;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Opponent {
    private final int number;
    private static final int MAX = 9;
    private static final int MIN = 1;
    public static final int SIZE = 3;

    public Opponent() {
        this.number = checkOverlap();
    }

    private static int createNums(){  //중복하지 않는 수를 반환한다.
        return Randoms.pickNumberInRange(MIN, MAX);
    }
    public static int checkOverlap() {//중복되지 않는 정수를 반환
        List<Integer> nums = new ArrayList<>();
        int result = 0;
        while(nums.size() < SIZE) {
            int num = createNums();
            if(!nums.contains(num)){
                nums.add(num);
            }
        }
        Collections.reverse(nums);
        for(int i = 0; i < SIZE; i++){  //각 자릿수 합치기
            result += nums.get(i)*Math.pow(10, i);
        }

        return result;
    }

    public int getNumber() {
        return number;
    }
}

