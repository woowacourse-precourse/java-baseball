package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public final static int digit = 3;
    public static void main(String[] args) {

    }

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < digit) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}
