package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        for (int i = 0; i < 100; i++) {
            System.out.println(Randoms.pickNumberInRange(1, 10));

        }
    }

    private static List<Integer> getThreeRandomNumber() {
        List<Integer> result = new ArrayList<>();

        while (result.size() < 3) {
            int tmpRandomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(tmpRandomNumber)) {
                result.add(tmpRandomNumber);
            }
        }

        return result;
    }
}
