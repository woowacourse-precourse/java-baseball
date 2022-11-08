package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class User {

    protected static final int NUM_LEN = 3;

    protected int[] userInput;
    private static HashSet checkDuplicate;


    public void getUserInput() {
        String tempInput = Console.readLine();
        if (valid(tempInput)) {
            userInput = Stream.of(
                    tempInput.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean valid(String tempInput) {
        checkDuplicate = new HashSet();
        for (int i = 0; i < 3; ++i) {
            if (!Character.isDigit(tempInput.charAt(i))
                || checkDuplicate.add(tempInput.charAt(i))
                || tempInput.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }
}
