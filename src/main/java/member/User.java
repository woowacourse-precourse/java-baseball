package member;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int STARTING_INDEX = 0;
    private static final int MAX_LENGTH_OF_NUMBER = 3;
    private final List<Integer> numbers = new ArrayList<>();

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (!isCorrectRange(input)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 게임 종료");
        }

        setNumber(input);
    }

    private boolean isCorrectRange(String inputNumber) {
        String pattern = "[1-9]{1,3}";

        return Pattern.matches(pattern, inputNumber);
    }

}
