package baseball;

import java.util.*;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SELECT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int NUMBER_LENGTH = 3;

    public static List<Integer> getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(INPUT_NUMBER_MESSAGE);
        String userInput = scanner.nextLine();
        userInputValidationCheck(userInput);
        return stringToList(userInput);
    }

    public static String restartGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(SELECT_RESTART_MESSAGE);
        String userInput = scanner.nextLine();
        userInputRestartValidationCheck(userInput);
        return userInput;
    }

    public static void userInputRestartValidationCheck(String userInput) {
        if (onlyOneOrTwo(userInput)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void userInputValidationCheck(String userInput) {
        if (isThreeLength(userInput) && isNumber(userInput) && haveNotZero(userInput) && notDuplicatedNumber(userInput)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private static boolean onlyOneOrTwo(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == '1' || userInput.charAt(i) == '2') {
                return true;
            }
        }
        return false;
    }

    private static boolean isThreeLength(String userInput) { // 세자리 수가 넘는 경우
        if (userInput.length() != NUMBER_LENGTH) {
            return false;
        }
        return true;
    }

    private static boolean isNumber(String userInput) { // 숫자가 아닌 값이 있는 경우
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean notDuplicatedNumber(String userInput) { // 숫자가 중복이 되는 경우
        Set<Character> inputSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            inputSet.add(userInput.charAt(i));
        }
        if (inputSet.size() == userInput.length()) {
            return true;
        }
        return false;
    }

    private static boolean haveNotZero(String userInput) { // 문자 중 0이 있는 경우
        for (int i = 0; i < userInput.length(); i++) {
            if ('0' == userInput.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> stringToList(String target) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            result.add(Character.getNumericValue(target.charAt(i)));
        }
        return result;
    }
}
