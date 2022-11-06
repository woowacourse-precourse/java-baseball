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

        while (result.size() < TRIPLE_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
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
            if (!(MIN_RANGE <= userInputIntValue && userInputIntValue <= MAX_RANGE)) {
                throw new IllegalArgumentException(USER_INPUT_IS_NOT_IN_RANGE);
            }
        }
    }

    static void validateUserInputIsThreeDigits(String userInput) {
        if (userInput.length() != TRIPLE_DIGITS) {
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
        int strikeCount = ZERO;

        for (int index = 0; index < userInput.size(); index++) {
            if (userInput.get(index).equals(answer.get(index))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    static int countBallInUserInput(List<Integer> userInput, List<Integer> answer) {
        int ballCount = ZERO;

        for (int index = 0; index < userInput.size(); index++) {
            if (userInput.contains(answer.get(index)) && !(userInput.get(index).equals(answer.get(index)))) {
                ballCount++;
            }
        }

        return ballCount;
    }

    static String makeOutput(int ballCount, int strikeCount) {
        if (ballCount == ZERO && strikeCount == ZERO) {
            return NOTTING;
        }

        if (strikeCount == THREE) {
            return ALL_STRIKES;
        }

        if (ballCount == ZERO) {
            return strikeCount + STRIKE;
        }

        if (strikeCount == ZERO) {
            return ballCount + BALL;
        }

        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    static int isRoundFinish(int ballCount, int strikeCount) {
        if (strikeCount == THREE && ballCount == ZERO) {
            return EXIT;
        }

        return START;
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
        if (START > userInput || userInput > EXIT) {
            throw new IllegalArgumentException(USER_INPUT_RANGE_ERROR);
        }
    }

    static void roundStart() {

        List<Integer> answer = generateThreeDigitsNumber();

        int state = START;
        while (state == START) {

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

        int state = START;

        while (state == START) {
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
