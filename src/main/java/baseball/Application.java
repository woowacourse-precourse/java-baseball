package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Map<String, List<Integer>> inputValue = new HashMap<>();
        int start = 1;
    }
    public static List<Integer> inputComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            computer = isContain(computer, randNum);
        }
        return computer;
    }
    public static List<Integer> isContain(List<Integer> list, int value) {
        if (!list.contains(value)) {
            list.add(value);
        }
        return list;
    }
}
