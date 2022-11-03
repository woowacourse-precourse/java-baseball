package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {

    public List<Integer> input() {
        System.out.print("숫자를 입력해 주세요 : ");
        String userInput = Console.readLine();

        ExceptionCheck check = new ExceptionCheck();
        check.verificationLength(userInput);
        check.verificationInputZero(userInput);
        check.verificationCharDetect(userInput);
        check.verificationDuplicated(userInput);

        return sliceInput(userInput);
    }

    public List<Integer> sliceInput(String userInput) {
        List<Integer> slice = new ArrayList<>();

        for (int seq = 0; seq < userInput.length(); seq++) {
            Integer slicedSequence = Character.getNumericValue(userInput.charAt(seq));
            slice.add(slicedSequence);
        }

        return slice;
    }
}
