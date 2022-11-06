package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static boolean isNumeric(String userInput) {
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> makeRandomNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static List<Integer> getUserNumber() {
        List<Integer> userInputNumber = new ArrayList<>();
        System.out.print("숫자를 입력해 주세요 : ");
        String userInput = readLine();
        if (userInput.length() != 3 || !isNumeric(userInput)) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            Integer tempNum = Integer.parseInt(String.valueOf(userInput.charAt(i)));
            if (tempNum.equals(0)) {
                throw new IllegalArgumentException();
            } else if (userInputNumber.contains(tempNum)) {
                throw new IllegalArgumentException();
            } else {
                userInputNumber.add(tempNum);
            }
        }
        return userInputNumber;
    }

    public static int countBall(List<Integer> computerNumber, List<Integer> userInputNumber) {
        int ball = 0;
        for (int i = 0; i < userInputNumber.size(); i++) {
            if (computerNumber.contains(userInputNumber.get(i)) && !(computerNumber.get(i).equals(userInputNumber.get(i)))) {
                ball++;
            }
        }
        return ball;
    }

    public static int countStrike(List<Integer> computerNumber, List<Integer> userInputNumber) {
        int strike = 0;
        for (int i = 0; i < userInputNumber.size(); i++) {
            if (computerNumber.get(i).equals(userInputNumber.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public static void printResult(int ball, int strike) {
        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public static boolean isGameEnd(int strike) {
        if (strike == 3) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Integer programEndFlag = 1;
        while (programEndFlag.equals(1)) {
            List<Integer> computerNumber = makeRandomNumber();
            boolean flag = false;
            while (!flag) {
                List<Integer> userInputNumber;
                try {
                    userInputNumber = getUserNumber();
                } catch (IllegalArgumentException exception) {
                    System.out.println("올바르지 않은 입력입니다!");
                    return;
                }
                int ball = countBall(computerNumber, userInputNumber);
                int strike = countStrike(computerNumber, userInputNumber);
                printResult(ball, strike);
                flag = isGameEnd(strike);
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            programEndFlag = Integer.parseInt(readLine());
        }
    }
}
