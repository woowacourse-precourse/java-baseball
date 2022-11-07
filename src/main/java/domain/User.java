package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<Integer> getUserNumber(String inputNumber) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNumbers.add(Integer.valueOf(inputNumber.split("")[i]));
        }
        return userNumbers;
    }

}
