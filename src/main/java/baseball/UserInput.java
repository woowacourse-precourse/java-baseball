package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public static List<Integer> input() {
        String userInput = Console.readLine();

        ExceptionCheck check = new ExceptionCheck();
        check.verificationInputZero(userInput);
        check.verificationCharDetect(userInput);
        check.verificationDuplicate(userInput);
        check.verificationLength(userInput);

        return sliceInput(userInput);
    }

}
