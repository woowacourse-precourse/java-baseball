package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> getRandomIntList() {
        List<Integer> randomInt = new ArrayList<>();
        while (randomInt.size() < 3) {
            int tempRan = Randoms.pickNumberInRange(1, 9);
            if (!randomInt.contains(tempRan)) {
                randomInt.add(tempRan);
            }
        }
        return randomInt;
    }
}