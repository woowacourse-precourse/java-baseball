package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

import java.util.List;
import java.util.Arrays;

import java.util.stream.Stream;

public class User {

    protected static final int NUM_LEN = 3;

    protected int[] userInput;
    private static HashSet checkDuplicate;

    public void getUserInput() {

        String tempInput = Console.readLine();

        // 유저가 입력한 값이 유효한지 확인
        if (valid(tempInput)) {
            // 유효한 경우 Stream을 활용하여 String -> ArrayList<Integer>로 mapping
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

        if (tempInput.length() != NUM_LEN){
            return false;
        }
        for (int i = 0; i < NUM_LEN; ++i) {
            if (!Character.isDigit(tempInput.charAt(i))
                || !checkDuplicate.add(tempInput.charAt(i))
                || tempInput.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }
}
