package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Baseball {
    public static List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public static int getBallCount(List<Integer> computer, List<Integer> user) {
        return (int) computer.stream().filter(user::contains).count();
    }
}
