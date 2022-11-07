package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private static final int LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String INPUT_SENTENCE = "숫자를 입력해주세요 : ";

    public List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private String getInputNumber() {
        System.out.print(INPUT_SENTENCE);
        String input = Console.readLine();

        if (isNotLength3(input) || hasNonNumber(input) || isDuplicated(input)) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public boolean isNotLength3(String input) {
        return input.length() != LENGTH;
    }

    public boolean hasNonNumber(String input) {
        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicated(String input) {
        for (int i = 0; i < input.length(); i++) {
            String check = input.substring(0, 1);
            input = input.substring(1);
            if (input.contains(check)) {
                return true;
            }
        }
        return false;
    }
}
