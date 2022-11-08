package baseball.player;

import static baseball.Constant.ERR_MSG;
import static baseball.Constant.INPUT_NUMBER_MSG;

import baseball.Validation;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private List<Integer> number = new ArrayList<>();
    private Validation validation;

    public User(Validation validation) {
        this.validation = validation;
    }

    public List<Integer> getNumber() throws IllegalArgumentException {
        System.out.print(INPUT_NUMBER_MSG);
        number = makeStringNumberToList();
        validation.validate(number);
        return number;
    }

    public List<Integer> makeStringNumberToList() {
        try {
            number = Arrays.stream(Console.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_MSG);
        }
        return number;
    }

}
