package baseball;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> convertStringToInteger(String input) {
        List<Integer> result = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            int digit = ch - '0';
            result.add(digit);
        }
        return result;
    }
}
