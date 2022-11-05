package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class User {

    public static final int MAX_SIZE = 3;

    public ArrayList<String> input(String inputNumbers) {
        validate(inputNumbers);

        ArrayList<String> userNumber = new ArrayList<>(Arrays.asList(inputNumbers.split("")));
        return userNumber;
    }

    public static void validate(String inputNumbers) {
        ArrayList<Character> userValidNumber = new ArrayList<>();

        if (inputNumbers.length() != MAX_SIZE) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < MAX_SIZE; i++) {
            if (inputNumbers.charAt(i) < '1' || inputNumbers.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
            if (userValidNumber.contains(inputNumbers.charAt(i))) {
                throw new IllegalArgumentException();
            }
            userValidNumber.add(inputNumbers.charAt(i));
        }
    }
}
