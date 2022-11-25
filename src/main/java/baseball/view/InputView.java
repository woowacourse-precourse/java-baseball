package baseball.view;

import static baseball.util.NumberValidator.validateNumberLength;
import static baseball.util.NumberValidator.validateNumberType;

import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Integer> readUserNumber() {
        String input = Console.readLine();
        System.out.println(input);
        // 세 자리 숫자가 아니면 예외 처리한다.
        validateNumberType(input);
        validateNumberLength(input);
        // 각 숫자가 1부터 9까지의 숫자가 아니면 예외 처리한다.
        // split to list

        // validation

        return List.of(0, 0, 0);
    }
}
