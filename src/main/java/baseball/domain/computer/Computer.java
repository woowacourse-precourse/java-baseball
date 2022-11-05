package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {

    public static String getRandomNumbers() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}
