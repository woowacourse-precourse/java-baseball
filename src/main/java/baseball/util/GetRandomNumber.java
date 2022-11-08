package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GetRandomNumber {

    public static String GetRandomNumber() {
        List<String> getNumbers = new ArrayList<>();
        while (getNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!getNumbers.contains(number)) {
                getNumbers.add(String.valueOf(number));
            }
        }
        String result = String.join(",", getNumbers);
        return result;
    }
}
