package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static String createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        int randomNumber = 0;
        while (computer.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return toString(computer);
    }

    public static String toString(List<Integer> list) {
        return list.toString().replaceAll("[^1-9]", "");
    }

    public static String inputBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        String baseballNumber = Console.readLine();
        validateBaseballNumber(baseballNumber);

        return baseballNumber;
    }

    public static String inputRestartNumber() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String restartNumber = Console.readLine();
        validateRestartNumber(restartNumber);

        return restartNumber;
    }

    public static int getStrike(String randomNumber, String baseballNumber) {
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (randomNumber.charAt(i) == (baseballNumber.charAt(i))) {
                strike++;
            }
        }

        return strike;
    }

    public static int getBall(String randomNumber, String baseballNumber) {
        int ball = 0;
        String[] randomNumberList = randomNumber.split("");

        for (String number : randomNumberList) {
            if (baseballNumber.contains(number)) {
                ball++;
            }
        }

        ball = ball - getStrike(randomNumber, baseballNumber);
        return ball;
    }

    public static String getHint(String randomNumber, String baseballNumber) {
        int strike = getStrike(randomNumber, baseballNumber);
        int ball = getBall(randomNumber, baseballNumber);
        String result = "";

        if (ball > 0 && strike > 0) {
            result = ball + "볼 " + strike + "스트라이크";
        } else if (ball == 0 && strike == 0) {
            result = "낫싱";
        } else if (strike == 0) {
            result = ball + "볼";
        } else if (ball == 0) {
            result = strike + "스트라이크";
        }

        System.out.println(result);
        return result;
    }

    public static boolean isGameOver(String str) {
        return str.equals("3스트라이크");
    }

    public static void checkLength(String baseballNumber) {
        // 세 자릿수가 아닌 경우 예외 처리
        if (baseballNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public static void checkNumber(String baseballNumber) {
        // 1 ~ 9 사이의 숫자가 아닌 경우 예외 처리
        for (int i = 0; i < 3; i++) {
            if (baseballNumber.charAt(i) < '1' || baseballNumber.charAt(i) > '9') {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    public static void checkDuplicate(String baseballNumber) {
        // 중복이 있는 경우 예외 처리
        Set<Character> hashSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            hashSet.add(baseballNumber.charAt(i));
        }
        if (hashSet.size() < 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public static void validateBaseballNumber(String baseballNumber) {
        checkLength(baseballNumber);
        checkNumber(baseballNumber);
        checkDuplicate(baseballNumber);
    }

    public static void validateRestartNumber(String restartNumber) {
        if (!(restartNumber.equals("2") || restartNumber.equals("1"))) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    public static void baseballGame() {
        String randomNumber = "";
        String restartNumber = "";

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            randomNumber = createRandomNumber();
            restartNumber = startGame(randomNumber);
        } while (!restartNumber.equals("2"));
    }

    public static String startGame(String randomNumber) {
        String restartNumber = "";
        String baseballNumber = "";
        String hint = "";

        while (true) {
            baseballNumber = inputBaseballNumber();
            hint = getHint(randomNumber, baseballNumber);

            if (isGameOver(hint)) {
                restartNumber = inputRestartNumber();
                break;
            }
        }
        return restartNumber;
    }

    public static void main(String[] args) {
        baseballGame();
    }
}
