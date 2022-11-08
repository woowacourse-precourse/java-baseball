package domain;

import java.util.ArrayList;
import java.util.List;

import static constant.Rules.DIGIT_RANGE;

public class User {
    public static List<Integer> getNumber(String inputNumber) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < DIGIT_RANGE; i++) {
            userNumbers.add(Integer.valueOf(inputNumber.split("")[i]));
        }
        return userNumbers;
    }

}
