package baseball.view.input;


import static baseball.utils.message.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputImpl implements Input {

    private static final String REGEX_BASEBALL = "^[1-9]{3}$";
    private static final String REGEX_END = "[12]{1}";

    @Override
    public String baseballInput() {
        String baseballInput = Console.readLine();
        validateBaseballInput(baseballInput);
        return baseballInput;
    }

    @Override
    public String endInput() {
        String endInput = Console.readLine();
        validateEndInput(endInput);
        return endInput;
    }

    private void validateBaseballInput(String baseballInput) throws IllegalArgumentException {
        String[] baseballNumber = baseballInput.split("");
        List<String> distinctNumber = Arrays.stream(baseballNumber)
                .distinct()
                .collect(Collectors.toList());
        if (!baseballInput.matches(REGEX_BASEBALL) || distinctNumber.size() != 3) {
            throw new IllegalArgumentException(BASEBALL_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private void validateEndInput(String endInput) {
        if (!endInput.matches(REGEX_END)) {
            throw new IllegalArgumentException(END_INPUT_EXCEPTION_MESSAGE);
        }
    }
}
