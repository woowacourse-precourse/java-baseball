package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class Baseball {
    public static List<Integer> getRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public static int getBallCount(List<Integer> computer, List<Integer> user) {
        return (int) computer.stream().filter(user::contains).count();
    }

    public static int getStrikeCount(List<Integer> computer, List<Integer> user) {
        return (int) IntStream.range(0, 3)
                .filter(i -> computer.get(i).equals(user.get(i)))
                .count();
    }
}
