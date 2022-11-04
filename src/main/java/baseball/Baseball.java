package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Baseball {
    public static List<Integer> getComputerNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(numbers);
    }

    public static int getBallCount(List<Integer> computer, List<Integer> user) {
        return (int) computer.stream().filter(user::contains).count();
    }

    public static int getStrikeCount(List<Integer> computer, List<Integer> user) {
        return (int) IntStream.range(0, 3).filter(i -> computer.get(i).equals(user.get(i))).count();
    }
}
