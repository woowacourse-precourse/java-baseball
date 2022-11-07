package baseball;

import java.util.ArrayList;
import java.util.List;

public class ResultValidator {
    public List<Integer> validate(String input, String createdNumber) {
        List<Integer> result = new ArrayList<>();
        int strike = countStrike(input, createdNumber);

        return result;
    }

    private int countStrike(String input, String createdNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == createdNumber.charAt(i)) {
                strike = strike + 1;
            }
        }
        return strike;
    }
}
