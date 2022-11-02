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

    public static List<Integer> sliceInput(String userInput) {
        List<Integer> slice = new ArrayList<>();
        for (int seq = 0; seq < userInput.length(); seq++) {
            Integer slicedSequence = Character.getNumericValue(userInput.charAt(seq));
            slice.add(slicedSequence);
        }
        return slice;
    }
}
