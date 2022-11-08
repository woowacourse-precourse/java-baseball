package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> answer = makeAnswer();
            baseballGame(answer);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = Console.readLine();
            if (userInput.equals("2"))
                break;
            if (!userInput.equals("1"))
                throw new IllegalArgumentException();
        }
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


    public static boolean numberCompare(List<Integer> answer, List<Integer> userInput) {
        boolean returnValue = false;
        int strike = 0;
        int ball = 0;
        List<Integer> numberFlag = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            numberFlag.add(0);
        }

        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == userInput.get(i)) {
                strike++;
            } else {
                numberFlag.set(userInput.get(i), 1);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (numberFlag.get(answer.get(i)) == 1)
                ball++;
        }

        if (strike == 3)
            returnValue = true;
        if (ball == 0 && strike == 0)
            System.out.print("낫싱");
        if (ball != 0)
            System.out.printf("%d볼 ", ball);
        if (strike != 0)
            System.out.printf("%d스트라이크", strike);
        System.out.println();

        return returnValue;
    }
}
