package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.Set;

public class Application {
    private static final int CNT_NUMBER = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputNumber = readLine();
        isValidInput(inputNumber);
    }

    private static void isValidInput(String input) {
        isDuplicated(input);
    }

    private static void isDuplicated(String str) {
        Set<Character> stringCharSet = new HashSet<>();
        str.chars().forEach(c -> stringCharSet.add((char) c));
        if (stringCharSet.size() != CNT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
