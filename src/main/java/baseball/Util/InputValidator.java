package baseball.Util;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
    private static InputValidator inputValidator;
    private static final int NINIMUM_NUMBER = 111;
    private static final int MAXIMUM_NUMBER = 999;
    private static final int EXACT_LENGTH = 3;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (inputValidator == null) {
            inputValidator = new InputValidator();
        }
        return inputValidator;
    }

    public static boolean validate(String numbers) {
        try {
            int userInput = Integer.parseInt(numbers);
            validateSize(userInput);
            validateSize(numbers);
            validateDuplicate(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static void validateSize(String number) {
        if (number.length() != EXACT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSize(int number) {
        if (number < NINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(int number) {
        HashSet<Integer> numberContainer = new HashSet<>();
        boolean hasNumber = true;
        while (number > 0) {
            hasNumber = numberContainer.add(number % 10);
            number /= 10;
            if (!hasNumber) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateisOneOrTwo(int number) {
        if (!(number == 1 || number == 2)) {
            throw new IllegalArgumentException();
        }
    }

    public static int validateRedo(String number) {
        try {
            int redo = Integer.parseInt(number);
            validateisOneOrTwo(redo);
            return redo;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
