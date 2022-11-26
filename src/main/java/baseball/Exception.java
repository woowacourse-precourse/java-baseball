package baseball;

import java.util.HashSet;
import java.util.List;

public class Exception {
    private static final int DIGIT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void userDigitNumberException(String user) {
        if (user.length() != DIGIT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void userNumberDuplicationException(String inputStringNumber) {
        String userNumber = "";

        for (int userIndex = 0; userIndex < inputStringNumber.length(); userIndex++) {
            String number = inputStringNumber.charAt(userIndex)+"";

            if (userNumber.contains(number)) {
                throw new IllegalArgumentException();
            }
            userNumber += number;
        }
    }

    public static void randomNumberRangeException(Integer randomNumber) {
        if ((randomNumber < MIN_NUMBER) || (randomNumber > MAX_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    public static void randomNumberDuplicationException(List<RandomNumber> randomNumbers) {
        HashSet<RandomNumber> nonDuplicateRandomNumbers = new HashSet<>();
        if (randomNumbers.size() != DIGIT_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
