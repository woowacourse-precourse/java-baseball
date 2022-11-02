package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    public static boolean isValid(List<Integer> numbers) {
        if (numbers.size() != 3) {
            return false;
        }
        return !numbers.get(0).equals(numbers.get(1))
                && !numbers.get(1).equals(numbers.get(2))
                && !numbers.get(2).equals(numbers.get(0));
    }
}
