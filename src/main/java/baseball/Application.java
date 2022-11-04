package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static List<Integer> targetNum = new ArrayList<>();

    public static void main(String[] args) {
        createRandomTargetNum();
    }

    public static void createRandomTargetNum() {
        while (targetNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!targetNum.contains(randomNumber)) {
                targetNum.add(randomNumber);
            }
        }
    }
}
