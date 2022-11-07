package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = getRandomNumberList();
        String userInput = getUserInput();
        List<Integer> userAnswer = convertStringToIntegerList(userInput);
    }

    private static List<Integer> getRandomNumberList() {
        List computer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return computer;
    }

    private static String getUserInput() {
        String userInput = Console.readLine();
        return userInput;
    }

    private static List<Integer> convertStringToIntegerList(String userInput) {
        List<String> userInputStringList = Arrays.asList(userInput.split(""));
        List<Integer> userAnswer = new ArrayList<>();

        for (String str : userInputStringList) {
            int converted = Integer.parseInt(str);
            userAnswer.add(converted);
        }

        return userAnswer;
    }

    private static boolean isUserInputLengthConstant(int minLength, int maxLength, String userInput) {
        if (userInput.length() < minLength && userInput.length() > maxLength) {
            return false;
        }

        return true;
    }

    private static boolean isUserInputNumeric(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            char eachChar = userInput.charAt(i);
            if (!Character.isDigit(eachChar)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isUserInputNotDuplicated(String userInput) {
        Set<String> tokenizedStringSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            tokenizedStringSet.add(userInput.substring(i, i + 1));
        }

        if(tokenizedStringSet.size() != userInput.length()) {
            return false;
        }

        return true;
    }

}
