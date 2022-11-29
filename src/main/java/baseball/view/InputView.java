package baseball.view;

import baseball.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {


    public List<Integer> readPlayerNumber() {
        String input = Validator.getValidatedPlayerNumber(Console.readLine());
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


}
