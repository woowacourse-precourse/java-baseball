package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static int strike, ball;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            playSmallGame();
        } while (isKeepGaming());
    }

    static boolean isKeepGaming() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endGame = Console.readLine();
        if (endGame.equals("1")) {
            return true;
        } else if (endGame.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    static void playSmallGame() {
        List<Integer> comNumbers = generateNumber();
        List<Integer> userNumbers;

        do {
            userNumbers = inputNumber();
            calc(userNumbers, comNumbers);
            printAResult(ball, strike);
        } while (isKeepSmallGaming());
    }

    static boolean isKeepSmallGaming() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        } else {
            return true;
        }
    }

    static List<Integer> generateNumber() {
        List<Integer> comNumbers = new ArrayList<>();
        do {
            int comNum = Randoms.pickNumberInRange(1, 9);
            if (!comNumbers.contains(comNum)) {
                comNumbers.add(comNum);
            }
        } while (comNumbers.size() < 3);
        return comNumbers;
    }

    static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userNum = Console.readLine();
        List<Integer> userNumbers = new ArrayList<>();
        if (userNum.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < 3; i++) {
            int digit = Integer.parseInt(userNum.substring(i, i + 1));
            userNumbers.add(digit);
        }

        int a = userNumbers.get(0);
        int b = userNumbers.get(1);
        int c = userNumbers.get(2);
        if (a == 0 || b == 0 || c == 0 || a == b || a == c || b == c) {
            throw new IllegalArgumentException();
        }

        return userNumbers;
    }

    static void calc(List<Integer> userNumbers, List<Integer> comNumbers) {
        strike = ball = 0;
        for (int i = 0; i < 3; i++) {
            int digit = userNumbers.get(i);
            if (digit == comNumbers.get(i)) {
                strike++;
            } else if (digit == comNumbers.get((i + 1) % 3) || digit == comNumbers.get((i + 2) % 3)) {
                ball++;
            }
        }
    }

    private static void printAResult(int ball, int strike) {
        String message = "";
        if (ball != 0) {
            message = ball + "볼";
        }
        if (ball != 0 && strike != 0) {
            message = message + " ";
        }
        if (strike != 0) {
            message = message + strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            message = "낫싱";
        }
        System.out.println(message);
    }
}