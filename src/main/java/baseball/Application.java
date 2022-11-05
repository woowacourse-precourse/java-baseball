package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        getStartMessage();

    }

    public static void getStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public static void getCorrectMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> getRandomValue() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static List<Character> getUserInput() {
        String input = Console.readLine();
        List<Character> inputList = new ArrayList<>();

        if (input.length() > 3) {throwInputException();}

        for (char x : input.toCharArray()) {
            if (!Character.isDigit(x) | inputList.contains(x)) {
                throwInputException();
            }
            inputList.add(x);
        }
            return inputList;
    }

    public static void throwInputException() {
        throw new IllegalArgumentException("3개의 서로 다른 숫자를 입력해주십시오");
    }

    public static List<Integer> charToInt(List<Character> userInput) {
        List<Integer> result = new ArrayList<>();

        for (char x : userInput) {
            result.add(Integer.parseInt(String.valueOf(x)));
        }
        return result;
    }

    public static int countBallStrike(List<Integer> answer, List<Integer> userInput) {
        int strikeCounter = 0;
        int ballCounter = 0;

        for (int i = 0; i < 3; i++) {
            int answerValue = answer.get(i);
            int userInputValue = userInput.get(i);

            if (answerValue == userInputValue) {
                strikeCounter++;
            } else if (answer.contains(userInputValue)) {
                ballCounter++;
            }
        }

        System.out.printf("%d볼 %d스트라이크",strikeCounter,ballCounter);

        return strikeCounter;
    }

    public static String chooseRestartExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하게요.");
        return Console.readLine();
    }

}
