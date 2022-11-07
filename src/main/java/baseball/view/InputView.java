package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String EVERY_CHARACTER = "";

    public List<Integer> promptNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return Arrays.stream(input.split(EVERY_CHARACTER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
