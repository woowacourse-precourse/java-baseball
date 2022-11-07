package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;


/**
 * camp.nextstep.edu.missionutils.Randoms 클래스의 메서드를 활용한 각종 기능을 제공하는 클래스
 */
public class RandomManager {

    public static Integer[] getDistinctIntegersInRange(int rangeStart, int rangeEnd, int count) {
        try {
            Set<Integer> integerSet = new HashSet<>();
            Integer[] integers = new Integer[count];

            for (int i = 0; i < count; i++) {
                Integer randomInt = null;
                while (i == integerSet.size()) {
                    randomInt = Randoms.pickNumberInRange(1, 9);
                    integerSet.add(randomInt);
                }
                integers[i] = randomInt;
            }
            return integers;
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

    }
}
