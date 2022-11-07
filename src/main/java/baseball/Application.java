package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

    }

    public static List<Integer> convertBaseBallByLine(String line) {
        if (!line.matches("^\\d{3}$")) {
            throw new IllegalArgumentException();
        }
        List<Integer> list = new ArrayList<>();
        for (String digit : line.split("")) {
            int value = Integer.parseInt(digit);
            if (list.contains(value)) {
                throw new IllegalArgumentException();
            }
            list.add(value);
        }
        return list;
    }

    public static List<Integer> createBaseBall() {
        List<Integer> baseBallNumber = new ArrayList<>();
        while (baseBallNumber.size() < 3) {
            int digit = Randoms.pickNumberInRange(0, 9);
            if (baseBallNumber.contains(digit)) {
                continue;
            }
            baseBallNumber.add(digit);
        }
        return baseBallNumber;
    }
}
