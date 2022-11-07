package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> getRandomNum() {
        List<Integer> result = new ArrayList<>();
        boolean[] duplicate = new boolean[10];
        int randNum;

        for (int i = 0; i < 3; i++) {
            randNum = Randoms.pickNumberInRange(1, 9);
            if (duplicate[randNum]) {
                i--;
                continue;
            } else {
                duplicate[randNum] = true;
                result.add(randNum);
            }
        }
        return result;
    }

}
