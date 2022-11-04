package baseball;

import baseball.utils.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void getBaseballInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        InputValidator.checkBaseballInput(input);
        this.numbers = stringToIntegerList(input);
    }

    private static List<Integer> stringToIntegerList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
