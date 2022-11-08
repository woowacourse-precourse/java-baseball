package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        List<Integer> computer = getRandomNumberList();
        String userInput = getUserInput();
        validate(userInput);
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

        if (tokenizedStringSet.size() != userInput.length()) {
            return false;
        }

        return true;
    }

    private static void validate(String userInput) {
        if (!isUserInputLengthConstant(3, 3, userInput)) {
            throw new IllegalArgumentException("값이 허용 범위를 벗어났습니다.");
        } else if (!isUserInputNumeric(userInput)) {
            throw new IllegalArgumentException("숫자 이외의 값이 있습니다.");
        } else if (!isUserInputNotDuplicated(userInput)) {
            throw new IllegalArgumentException("문자가 중복되었습니다.");
        }
    }

    private static Integer getElementBallOrStrike(List<Integer> computer, Integer index, Integer element) {
        //볼인 경우 1, 스트라이크인 경우 2, 아무것도 아닌 경우 0을 반환
        for (int i = 0; i < computer.size(); i++) {
            if (i != index && element == computer.get(i)) {
                return 1;
            } else if (i == index && element == computer.get(i)) {
                return 2;
            }
        }
        return 0;
    }

    private static List<Integer> getUserAnswerBallAndStrike(List<Integer> computer, List<Integer> userAnswer) {
        List<Integer> ballAndStrike = Arrays.asList(0, 0, 0);
        for(int i = 0; i < userAnswer.size(); i++) {
            int ballOrStrike = getElementBallOrStrike(computer, i, userAnswer.get(i));
            ballAndStrike.set(ballOrStrike, ballAndStrike.get(i) + 1);
        }

        return ballAndStrike;
    }

}
