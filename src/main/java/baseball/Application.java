package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static private List<Integer> userNumber = new ArrayList<>();
    static private List<Integer> computerNumber = new ArrayList<>();

    static void registerUserNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String input = Console.readLine();
        if (isValidNumber(input)) {
            int inputNumber = Integer.parseInt(input);
            userNumber = NumberToIntegerList(inputNumber);
        }
    }

    static boolean isValidNumber(String input) throws IllegalArgumentException {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (99 > inputNumber || 999 < inputNumber) {
            throw new IllegalArgumentException();
        }
        List<Integer> inputNumberList = NumberToIntegerList(inputNumber);
        if (inputNumberList.contains(0)) {
            throw new IllegalArgumentException();
        }
        if (inputNumberList.size() != inputNumberList.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    static List<Integer> NumberToIntegerList(int number) {
        List<Integer> digits = new ArrayList<>();
        int divisor = 100;
        for (int i = 0; i < 3; i++) {
            int digit = number / divisor;
            digits.add(digit);
            number %= divisor;
            divisor /= 10;
        }
        return digits;
    }

    static void registerComputerNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        computerNumber = randomNumbers;
    }

    static void playGame() {
        while (true) {
            registerUserNumber();
//            System.out.println(userNumber);
//            System.out.println(computerNumber);
            if (judgeCount() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return;
            }
        }
    }

    static int judgeCount() {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int currentUserNumber = userNumber.get(i);
            int currentComputerNumber = computerNumber.get(i);
            if (currentUserNumber == currentComputerNumber) {
                strike++;
                continue;
            }
            if (computerNumber.contains(currentUserNumber)) {
                ball++;
            }
        }
        printJudgeResult(strike, ball);
        return strike;
    }

    static void printJudgeResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }
        if (strike > ball) {
            System.out.println(strike + "스트라이크");
            return;
        }
        System.out.println(ball + "볼");
    }

    static boolean isRestart() {
        String input = Console.readLine();
        int restart;
        try {
            restart = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (restart == 1) {
            return true;
        }
        if (restart == 2) {
            return false;
        }
        throw new IllegalArgumentException();
    }

    static void setGame() {
        registerComputerNumber();
        playGame();
    }

    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            setGame();
            while (isRestart()) {
                setGame();
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e);
            throw new IllegalArgumentException();
        }
    }
}