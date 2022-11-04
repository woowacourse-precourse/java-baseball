package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class NumberScanner {

    public static List<Integer> getNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        System.out.printf("숫자를 입력해주세요: ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char c : input.toCharArray()) {
            if (c < 49 || c > 57) {
                throw new IllegalArgumentException();
            }
        }

        return userNumbers;
    }
}
