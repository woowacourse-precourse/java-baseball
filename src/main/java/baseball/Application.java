package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int reGame = 1;

        do {
            playGame();
            reGame = getReGame();
        } while (reGame == 1);
    }

    public static List<Integer> getRandomNumberList() {
        List computer = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        System.out.println(computer);
        return computer;
    }

    public static String getUserInput() {
        String userInput = Console.readLine();
        return userInput;
    }

    public static List<Integer> convertStringToIntegerList(String userInput) {
        List<String> userInputStringList = Arrays.asList(userInput.split(""));
        List<Integer> userAnswer = new ArrayList<>();

        for (String str : userInputStringList) {
            int converted = Integer.parseInt(str);
            userAnswer.add(converted);
        }

        return userAnswer;
    }

    public static boolean isUserInputLengthConstant(int minLength, int maxLength, String userInput) {
        if (userInput.length() < minLength || userInput.length() > maxLength) {
            return false;
        }

        return true;
    }

    public static boolean isUserInputNumeric(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            char eachChar = userInput.charAt(i);
            if (!Character.isDigit(eachChar)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isUserInputNotDuplicated(String userInput) {
        Set<String> tokenizedStringSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            tokenizedStringSet.add(userInput.substring(i, i + 1));
        }

        if (tokenizedStringSet.size() != userInput.length()) {
            return false;
        }

        return true;
    }

    public static void validate(String userInput) {
        if (!isUserInputLengthConstant(3, 3, userInput)) {
            throw new IllegalArgumentException("값이 허용 범위를 벗어났습니다.");
        } else if (!isUserInputNumeric(userInput)) {
            throw new IllegalArgumentException("숫자 이외의 값이 있습니다.");
        } else if (!isUserInputNotDuplicated(userInput)) {
            throw new IllegalArgumentException("문자가 중복되었습니다.");
        }
    }

    public static Integer getElementBallOrStrike(List<Integer> computer, Integer index, Integer element) {
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

    public static List<Integer> getUserAnswerBallAndStrike(List<Integer> computer, List<Integer> userAnswer) {
        List<Integer> ballAndStrike = Arrays.asList(0, 0, 0);
        for (int i = 0; i < userAnswer.size(); i++) {
            int ballOrStrike = getElementBallOrStrike(computer, i, userAnswer.get(i));
            ballAndStrike.set(ballOrStrike, ballAndStrike.get(ballOrStrike) + 1);
        }

        return ballAndStrike;
    }

    public static Integer getResult(List<Integer> ballAndStrike) {
        //정답인 경우 1, n 볼 m 스트라이크의 경우 2, 낫싱인 경우 0을 반환
        if (ballAndStrike.get(2) == 3) {
            return 1;
        } else if (ballAndStrike.get(0) == 3) {
            return 0;
        }
        
        return 2;
    }

    public static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = getRandomNumberList();
        int result = 0;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = getUserInput();
            validate(userInput);
            List<Integer> userAnswer = convertStringToIntegerList(userInput);

            List<Integer> ballAndStrike = getUserAnswerBallAndStrike(computer, userAnswer);
            System.out.println(parseResult(ballAndStrike));
            result = getResult(ballAndStrike);
        } while (result != 0);

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }

    public static String parseResult(List<Integer> ballAndStrike) {
        if(ballAndStrike.get(0) == 3) {
            return "낫싱";
        }

        String parsedResult = "";

        if (ballAndStrike.get(1) > 0) {
            parsedResult += ballAndStrike.get(1) + "볼 ";
        }

        if (ballAndStrike.get(2) > 0) {
            parsedResult += ballAndStrike.get(2) + "스트라이크 ";
        }

        return parsedResult;
    }

    public static Integer getReGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        validateReGame(choice);
        return Integer.parseInt(choice);
    }

    public static void validateReGame(String choice) {
        if (choice.equals("1") || choice.equals("2")) {
            throw new IllegalArgumentException("올바른 입력값이 아닙니다.");
        }
    }

}
