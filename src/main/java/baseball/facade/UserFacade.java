package baseball.facade;

import baseball.service.validation.ValidationService;
import baseball.service.validation.ValidationServiceImpl;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserFacade {
    private final ValidationService validationService = new ValidationServiceImpl();

    private final static int VALUE_SIZE = 3;

    public List<Integer> getInputValue() {
        View.inputNumber();
        String input = Console.readLine();

        validationService.validateIsNumber(input);

        List<Integer> list = new ArrayList<>();
        Arrays.stream(input.split(""))
            .mapToInt(Integer::parseInt)
            .forEach(list::add);

        validationService.validateNumberLength(VALUE_SIZE, list);
        validationService.validateDuplicate(list, VALUE_SIZE);

        return list;
    }
}
