package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userInput;
    private List<Integer> validatedInput;

    public void setUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        userInput = input;
    }

    private void validateUserInput() {
        Validator validator = new Validator(userInput);
        validator.isLengthThree();
        validator.isAllNumber();
        validator.notContainsZero();
        validator.isAllDifferent();
    }

    private void setValidatedInput() {
        try {
            validateUserInput();
            List<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < userInput.length(); i++) {
                arrayList.add(userInput.charAt(i) - '0');
            }
            validatedInput = arrayList;
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public List<Integer> getValidatedInput() {
        try {
            setValidatedInput();
            return validatedInput;
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
