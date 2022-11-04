package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static List<Integer> numbers;

    public static List<Integer> getNumbers() {
        numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
