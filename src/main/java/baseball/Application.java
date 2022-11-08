package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }

    public static List<Integer> makeAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static void baseballGame(List<Integer> answer) {
        boolean exit = false;
        while (!exit) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInputString = Console.readLine();
            List<Integer> userInput = changeInput(userInputString);
            exit = numberCompare(answer, userInput);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static List<Integer> changeInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (userInput.charAt(i) < '0' || userInput.charAt(i) > '9') {
                throw new IllegalArgumentException();
            }
        }
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userInputList.add(userInput.charAt(i) - '0');
        }
        return userInputList;
    }

}
