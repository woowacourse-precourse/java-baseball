package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Integer> stringToList(String inputNumbers) {
        List<Integer> inputThreeNumbers = new ArrayList<>();
        for (char c : inputNumbers.toCharArray()) {
            inputThreeNumbers.add(c - '0');
        }
        return inputThreeNumbers;
    }
}
