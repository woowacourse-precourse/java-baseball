package baseball.controller;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    /** 중복되지 않은 1~9까지 숫자 3개 List 반환 */
    public static List<Integer> createRandomNums(){
        List<Integer> correctNums = new ArrayList<>();
        while (correctNums.size()<3) {
            int temp = pickNumberInRange(1,9);
            if (!correctNums.contains(temp)) {
                correctNums.add(temp);
            }
        }
        return correctNums;
    }
}
