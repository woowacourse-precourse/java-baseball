package baseball;

import static baseball.Constants.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    static List<Integer> generateThreeDigitsNumber() {
        List<Integer> result = new ArrayList<>();

        while (result.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }

        return result;
    }

    static void validateUserInput(String userInput) {

        validateUserInputIsNullOrEmpty(userInput);
        validateUserInputIsThreeDigits(userInput);
        validateUserInputIsMinRangeToMaxRange(userInput);
        validateUserInputHasDuplicateNumber(userInput);
    }

    static void validateUserInputHasDuplicateNumber(String userInput) {
        Set<Integer> set = new HashSet<>();
        for (int index = 0; index < userInput.length(); index++) {
            int userInputIntValue = userInput.charAt(index) - '0';

            if (set.contains(userInputIntValue)) {
                throw new IllegalArgumentException(USER_INPUT_HAS_DUPLICATED_NUMBER);
            }

            set.add(userInputIntValue);
        }
    }

    static void validateUserInputIsMinRangeToMaxRange(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            int userInputIntValue = userInput.charAt(index) - '0';
            if (!(1 <= userInputIntValue && userInputIntValue <= 9)) {
                throw new IllegalArgumentException(USER_INPUT_IS_NOT_IN_RANGE);
            }
        }
    }

    static void validateUserInputIsThreeDigits(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(USER_INPUT_IS_NOT_THREE_DIGITS);
        }
    }

    static void validateUserInputIsNullOrEmpty(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException(USER_INPUT_IS_NULL_OR_EMPTY);
        }
    }

    static List<Integer> stringToIntList(String userInput) {
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < userInput.length(); index++) {
            int userInputIntValue = userInput.charAt(index) - '0';
            result.add(userInputIntValue);
        }

        return result;
    }

    static int countStrikeInUserInput(List<Integer> userInput, List<Integer> answer) {
        int strikeCount = 0;

        for (int index = 0; index < userInput.size(); index++) {
            if (userInput.get(index).equals(answer.get(index))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    static int countBallInUserInput(List<Integer> userInput, List<Integer> answer) {
        int ballCount = 0;

        for (int index = 0; index < userInput.size(); index++) {
            if (userInput.contains(answer.get(index)) && !(userInput.get(index).equals(answer.get(index)))) {
                ballCount++;
            }
        }

        return ballCount;
    }

    static String makeOutput(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTTING;
        }

        if (strikeCount == 3) {
            return ALL_STRIKES;
        }

        if (ballCount == 0) {
            return strikeCount + STRIKE;
        }

        if (strikeCount == 0) {
            return ballCount + BALL;
        }

        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    static int isRoundFinish(int ballCount, int strikeCount) {
        if (strikeCount == 3 && ballCount == 0) {
            return 2;
        }

        return 1;
    }

    static void validateUserInputType(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(USER_INPUT_TYPE_ERROR);
        }
    }

    static int stringToInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    static void validateUserInputIsStartOrExit(int userInput) {
        if (1 > userInput || userInput > 2) {
            throw new IllegalArgumentException(USER_INPUT_RANGE_ERROR);
        }
    }

    static void roundStart() {

        List<Integer> answer = generateThreeDigitsNumber();

        int state = 1;
        while (state == 1) {

            System.out.print(USER_INPUT_TEXT);
            String userInput = Console.readLine();
            validateUserInput(userInput);
            List<Integer> userInputIntList = stringToIntList(userInput);

            int strikeCount = countStrikeInUserInput(userInputIntList, answer);
            int ballCount = countBallInUserInput(userInputIntList, answer);

            String output = makeOutput(ballCount, strikeCount);
            System.out.println(output);

            state = isRoundFinish(ballCount, strikeCount);
        }
    }

    static void gameStart() {
        System.out.println(INTRO_TEXT);

        int state = 1;

        while (state == 1) {
            roundStart();

            System.out.println(RESTART_OR_EXIT_TEXT);
            String userInput = Console.readLine();

            validateUserInputType(userInput);
            int userInputIntValue = stringToInt(userInput);
            validateUserInputIsStartOrExit(userInputIntValue);

            state = userInputIntValue;
        }
    }
}
