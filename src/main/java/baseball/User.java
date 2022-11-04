package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {

    ValidationNumber validationNumber;
    String input;

    User() {
        validationNumber = new ValidationNumber();
    }

    public List<Integer> inputGameNumber() {
        input = Console.readLine();
        return validationNumber.checkTotalAndConvertIntegerList(input);
    }

    public String inputEndOrRestart() {
        input = Console.readLine();
        validationNumber.checkEndOrRestartNumber(input);
        return input;
    }
}
